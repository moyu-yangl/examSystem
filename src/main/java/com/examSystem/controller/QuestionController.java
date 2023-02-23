package com.examSystem.controller;

import com.examSystem.domain.ResponseResult;
import com.examSystem.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * 通过课程id查询该课程的所有试题
     *
     * @param courseId
     * @return
     */
    @GetMapping("/course/publish/question/{courseId}")
    public ResponseResult getCourseQuestion(@PathVariable Long courseId) {
        return questionService.getQuestionByCourseId(courseId);
    }
}
