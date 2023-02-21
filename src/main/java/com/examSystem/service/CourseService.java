package com.examSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.entity.Course;

public interface CourseService extends IService<Course> {
    ResponseResult listCourse(Integer pageNum, Integer pageSize);
}
