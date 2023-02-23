package com.examSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.dot.AnswerDto;
import com.examSystem.domain.dot.ExamAddDto;
import com.examSystem.domain.entity.Exam;


/**
 * 考试表(Exam)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 14:24:38
 */
public interface ExamService extends IService<Exam> {

    ResponseResult publishExam(ExamAddDto examAddDto);

    ResponseResult checkExam(Integer pageNum, Integer pageSize, Long userId, Long courseId);

    ResponseResult examListByCourseId(Long courseId);

    ResponseResult breakExam(AnswerDto answerDto);
}

