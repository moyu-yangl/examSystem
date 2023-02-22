package com.examSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.dot.CourseAddDto;
import com.examSystem.domain.entity.Course;

public interface CourseService extends IService<Course> {
    ResponseResult joinCourse(Integer pageNum, Integer pageSize, Long courseId, String courseName);

    ResponseResult publishCourse(Integer pageNum, Integer pageSize, Long courseId, String courseName);

    ResponseResult addCourse(CourseAddDto courseAddDto);
}
