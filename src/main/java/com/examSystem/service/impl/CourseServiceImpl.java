package com.examSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.dot.CourseAddDto;
import com.examSystem.domain.entity.Course;
import com.examSystem.domain.entity.UserCourse;
import com.examSystem.domain.vo.CourseVo;
import com.examSystem.domain.vo.PageVo;
import com.examSystem.enums.HttpCodeEnum;
import com.examSystem.exception.SystemException;
import com.examSystem.mapper.CourseMapper;
import com.examSystem.service.CourseService;
import com.examSystem.service.UserCourseService;
import com.examSystem.service.UserService;
import com.examSystem.utils.BeanCopyUtils;
import com.examSystem.utils.SecurityContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程表(Course)表服务实现类
 *
 * @author makejava
 * @since 2023-02-21 20:06:30
 */
@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserCourseService userCourseService;

    @Override
    public ResponseResult joinCourse(Integer pageNum, Integer pageSize, Long courseId, String courseName) {

        if (!StringUtils.hasText(courseName)) {
            courseName = null;
        }

        Long userId = SecurityContextUtils.getUserId();
        List<CourseVo> courseVos = baseMapper.listAllByUserId(userId, (pageNum - 1) * pageSize,
                pageSize, courseId, courseName);
        PageVo pageVo = new PageVo(courseVos, (long) courseVos.size());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult publishCourse(Integer pageNum, Integer pageSize, Long courseId, String courseName) {
        if (!StringUtils.hasText(courseName)) {
            courseName = null;
        }
        Long userId = SecurityContextUtils.getUserId();
        List<CourseVo> courseVos = baseMapper.listAllCourseByUserId(userId, (pageNum - 1) * pageSize,
                pageSize, courseId, courseName);
        PageVo pageVo = new PageVo(courseVos, (long) courseVos.size());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult addCourse(CourseAddDto courseAddDto) {
        Long userId = SecurityContextUtils.getUserId();
        Course course = BeanCopyUtils.copyBean(courseAddDto, Course.class);

        try {
            save(course);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException(HttpCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
        }
        List<UserCourse> courses = new ArrayList<>();
        for (Long studentId : courseAddDto.getStudentIds()) {
            UserCourse userCourse = new UserCourse();
            userCourse.setCourseId(course.getCourseId());
            userCourse.setCourseName(course.getCourseName());
            userCourse.setUserId(studentId);
            userCourse.setUserName(userService.getNameByUserId(studentId));
            courses.add(userCourse);
        }
        try {
            userCourseService.saveBatch(courses);
        } catch (Exception e) {
            removeById(course.getCourseId());
            throw new SystemException(HttpCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
        }
        return ResponseResult.okResult();
    }
}

