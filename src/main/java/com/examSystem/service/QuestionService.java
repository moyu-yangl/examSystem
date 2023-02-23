package com.examSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.dot.QuestionAddDto;
import com.examSystem.domain.dot.QuestionUpdateDto;
import com.examSystem.domain.entity.Question;


/**
 * 考题表(Question)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 21:42:26
 */
public interface QuestionService extends IService<Question> {

    ResponseResult getQuestionByCourseId(Long courseId);

    ResponseResult addQuestion(QuestionAddDto questionAddDto);

    ResponseResult deleteQuestion(Long courseId, Long questionId);

    ResponseResult updateQuestionById(QuestionUpdateDto questionDto);

    ResponseResult checkQuestionList(Long courseId, Long examId, String state);
}

