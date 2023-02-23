package com.examSystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.constant.SystemConstant;
import com.examSystem.domain.dot.AnswerDto;
import com.examSystem.domain.dot.ExamAddDto;
import com.examSystem.domain.dot.QuestionDto;
import com.examSystem.domain.entity.*;
import com.examSystem.domain.vo.ExamInfoVo;
import com.examSystem.domain.vo.ScoreInfo;
import com.examSystem.enums.HttpCodeEnum;
import com.examSystem.exception.SystemException;
import com.examSystem.mapper.ExamMapper;
import com.examSystem.service.*;
import com.examSystem.utils.BeanCopyUtils;
import com.examSystem.utils.SecurityContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 考试表(Exam)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 14:24:38
 */
@Service("examService")
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {

    @Autowired
    private UserCourseService userCourseService;
    @Autowired
    private UserExamService userExamService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserService userService;

    @Autowired
    private AnswersService answerService;

    @Transactional
    @Override
    public ResponseResult publishExam(ExamAddDto examAddDto) {

        //该课程需要是未发布课程的
        Course course = courseService.getById(examAddDto.getCourseId());
        if (course.getState().equals("1")) {
            //已经发布了考试
            throw new SystemException(HttpCodeEnum.EXAMED);
        }

        //给该课程增加一次考试
        Exam exam = BeanCopyUtils.copyBean(examAddDto, Exam.class);

//        exam.setStartTime();
        save(exam);
        //将所有该课程下的学生加入到这次考试

        //查询该课程下的学生的id 姓名
        List<UserCourse> list = userCourseService.listByCourseId(examAddDto.getCourseId());

        List<UserExam> userExamList = new ArrayList<>();
        for (UserCourse userCourse : list) {
            userExamList.add(new UserExam(userCourse.getUserId(), exam.getExamId()));
        }
        //保存
        userExamService.saveBatch(userExamList);

        //将该课程设置为已发布考试
        course.setState("1");
        courseService.updateById(course);

        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult checkExam(Integer pageNum, Integer pageSize, Long Id, Long courseId) {
        //查询该学生所有的考试信息
        List<Exam> exams = baseMapper.listAllByUserId((pageNum - 1) * pageSize, pageSize, SecurityContextUtils.getUserId(), courseId);
        List<ExamInfoVo> examInfoVos = BeanCopyUtils.copyBeanList(exams, ExamInfoVo.class);
        for (ExamInfoVo exam : examInfoVos) {
            Long id = exam.getCourseId();
            Course course = courseService.getById(id);
            Long userId = course.getUserId();
            User byId = userService.getById(userId);
            exam.setTeacherName(byId.getName());
            exam.setCourseName(course.getCourseName());
        }
        return ResponseResult.okResult(examInfoVos);
    }

    @Override
    public ResponseResult examListByCourseId(Long courseId) {
        List<Exam> exams = baseMapper.listAllByCourseId(courseId);
        List<ScoreInfo> scoreInfo = BeanCopyUtils.copyBeanList(exams, ScoreInfo.class);
        for (ScoreInfo score : scoreInfo) {
            Long examId = score.getExamId();
            LambdaQueryWrapper<UserExam> lambda = new LambdaQueryWrapper<>();
            ;
            UserExam one = userExamService.getOne(lambda.eq(UserExam::getExamId, examId));
            Long userId = one.getUserId();
            String name = userService.getById(userId).getName();
            score.setUserName(name);

            Long id = score.getCourseId();
            Course course = courseService.getById(id);
            Long userId2 = course.getUserId();
            User byId = userService.getById(userId2);
            score.setTeacherName(byId.getName());
            score.setCourseName(course.getCourseName());

        }
        return ResponseResult.okResult(scoreInfo);
    }

    @Transactional
    @Override
    public ResponseResult breakExam(AnswerDto answerDto) {
        //中途退出

        //将该考试状态置为2（中途退出）
        Exam exam = getById(answerDto.getExamId());
        exam.setState(SystemConstant.STATE_NO);
        updateById(exam);
        //将已经选了的试题连同答案加入数据库
        List<QuestionDto> questions = answerDto.getQuestions();
        List<Answers> answers = BeanCopyUtils.copyBeanList(questions, Answers.class);

        for (Answers answer : answers) {
            answer.setUserId(answerDto.getUserId());
            answer.setExamId(answerDto.getExamId());
        }

        answerService.saveBatch(answers);

        return ResponseResult.okResult();
    }

}

