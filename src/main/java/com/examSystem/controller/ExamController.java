package com.examSystem.controller;

import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.dot.AnswerDto;
import com.examSystem.domain.dot.ExamAddDto;
import com.examSystem.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExamController {
    @Autowired
    private ExamService examService;

    @PostMapping("/exam/add/publish")
    public ResponseResult publishExam(@RequestBody ExamAddDto examAddDto) {
        return examService.publishExam(examAddDto);
    }

    //    @GetMapping("/exam/add")
//    public ResponseResult addExam() {
//        return examService.addExam();
//    }
//
    @GetMapping("/exam/check")
    public ResponseResult checkExam(Integer pageNum, Integer pageSize, Long courseId, String courseName) {
        return examService.checkExam(pageNum, pageSize, null, courseId);
    }

    @GetMapping("/exam/add/{courseId}")
    public ResponseResult addExamList(@PathVariable Long courseId) {
        return examService.examListByCourseId(courseId);
    }

    @PostMapping("/exam/check/break")
    public ResponseResult breakExam(@RequestBody AnswerDto answerDto) {
        return examService.breakExam(answerDto);
    }

}
