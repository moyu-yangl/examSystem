package com.examSystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.constant.SystemConstant;
import com.examSystem.domain.dot.QuestionAddDto;
import com.examSystem.domain.dot.QuestionUpdateDto;
import com.examSystem.domain.entity.CourseQuestion;
import com.examSystem.domain.entity.Question;
import com.examSystem.domain.vo.QuestionInfoVo;
import com.examSystem.domain.vo.QuestionVo;
import com.examSystem.enums.HttpCodeEnum;
import com.examSystem.exception.SystemException;
import com.examSystem.mapper.QuestionMapper;
import com.examSystem.service.CourseQuestionService;
import com.examSystem.service.QuestionService;
import com.examSystem.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 考题表(Question)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 21:42:26
 */
@Service("questionService")
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Autowired
    private CourseQuestionService courseQuestionService;

    @Override
    public ResponseResult getQuestionByCourseId(Long courseId) {
        List<QuestionInfoVo> list = baseMapper.getQuestionListByCourseId(courseId);
        return ResponseResult.okResult(list);
    }

    @Transactional
    @Override
    public ResponseResult addQuestion(QuestionAddDto questionAddDto) {
        Question question = BeanCopyUtils.copyBean(questionAddDto, Question.class);
        save(question);
        CourseQuestion courseQuestion = new CourseQuestion();
        courseQuestion.setCourseId(questionAddDto.getCourseId());
        courseQuestion.setQuestionId(question.getQuestionId());
        courseQuestionService.save(courseQuestion);

        return ResponseResult.okResult();
    }

    @Transactional
    @Override
    public ResponseResult deleteQuestion(Long courseId, Long questionId) {

        LambdaQueryWrapper<CourseQuestion> lambda = new LambdaQueryWrapper<>();
        lambda.eq(CourseQuestion::getCourseId, courseId);
        lambda.eq(CourseQuestion::getQuestionId, questionId);
        courseQuestionService.remove(lambda);

        removeById(questionId);

        return ResponseResult.okResult();
    }

    @Transactional
    @Override
    public ResponseResult updateQuestionById(QuestionUpdateDto questionDto) {
        Question question = BeanCopyUtils.copyBean(questionDto, Question.class);
        //如果是填空题，则把选项都置空
        if ("t".equals(question.getQuestionType())) {
            question.setOptionA("");
            question.setOptionB("");
            question.setOptionC("");
            question.setOptionD("");
        }
        updateById(question);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult checkQuestionList(Long courseId, Long examId, String state) {
        //判断考试的状态

        if (SystemConstant.STATE_INITIAL.equals(state)) {
            //如果是未考

            return notExamined(courseId);
        } else if (SystemConstant.STATE_NO.equals(state)) {
            //如果是中途退出了
            return ResponseResult.okResult();
        } else {
            throw new SystemException(HttpCodeEnum.SYSTEM_ERROR);
        }
    }

    private ResponseResult notExamined(Long courseId) {
        //查询该课程下的所有试题并返回给前端
        List<Long> questions = courseQuestionService.selectAllByCourseId(courseId);
        LambdaQueryWrapper<Question> queryWrap = new LambdaQueryWrapper<>();
        queryWrap.in(Question::getQuestionId, questions);
        queryWrap.orderByDesc(Question::getQuestionType);
        queryWrap.orderByAsc(Question::getQuestionId);
        List<Question> list = list(queryWrap);

        List<QuestionVo> questionVos = BeanCopyUtils.copyBeanList(list, QuestionVo.class);

        return ResponseResult.okResult(questionVos);
    }

    private ResponseResult breakExamined(Long courseId, Long examId) {

        
        return ResponseResult.okResult();
    }
}

