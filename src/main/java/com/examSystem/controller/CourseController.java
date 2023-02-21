package com.examSystem.controller;

import com.examSystem.domain.ResponseResult;
import com.examSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course/list")
    public ResponseResult listCourse(Integer pageNum, Integer pageSize) {
        return courseService.listCourse(pageNum, pageSize);
    }
}
