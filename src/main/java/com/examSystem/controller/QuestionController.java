package com.examSystem.controller;

import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.dot.QuestionAddDto;
import com.examSystem.domain.dot.QuestionUpdateDto;
import com.examSystem.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/course/publish/question")
    public ResponseResult addQuestion(@RequestBody QuestionAddDto questionAddDto) {
        return questionService.addQuestion(questionAddDto);
    }

    @DeleteMapping("/course/publish/question")
    public ResponseResult deleteQuestion(Long courseId, Long questionId) {
        return questionService.deleteQuestion(courseId, questionId);
    }

    @PutMapping("/course/publish/question")
    public ResponseResult updateQuestion(@RequestBody QuestionUpdateDto questionDto) {
        return questionService.updateQuestionById(questionDto);
    }

    @GetMapping("/exam/check/question")
    public ResponseResult checkQuestionList(Long courseId, Long examId, String state) {
        return questionService.checkQuestionList(courseId, examId, state);
    }
}
