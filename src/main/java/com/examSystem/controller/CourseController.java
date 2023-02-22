package com.examSystem.controller;

import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.dot.CourseAddDto;
import com.examSystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 分页查看所有学生加入的课程
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/course/join")
    public ResponseResult joinCourse(Integer pageNum, Integer pageSize, Long courseId, String courseName) {
        return courseService.joinCourse(pageNum, pageSize, courseId, courseName);
    }

    /**
     * 分页查询教师所发布的课程
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/course/publish")
    public ResponseResult publishCourse(Integer pageNum, Integer pageSize, Long courseId, String courseName) {
        return courseService.publishCourse(pageNum, pageSize, courseId, courseName);
    }

    @PostMapping("/course/publish/add")
    public ResponseResult publishCourseAdd(@RequestBody CourseAddDto courseAddDto) {
        return courseService.addCourse(courseAddDto);
    }
}
