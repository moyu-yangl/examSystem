package com.examSystem.controller;

import com.examSystem.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamController {
    @Autowired
    private ExamService examService;

//    @GetMapping("/exam/add")
//    public ResponseResult addExam() {
//        return examService.addExam();
//    }
//
//    @GetMapping("/exam/check")
//    public ResponseResult checkExam() {
//        return examService.checkExam();
//    }
}
