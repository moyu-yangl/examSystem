package com.examSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.examSystem.domain.entity.Question;
import com.examSystem.domain.vo.QuestionInfoVo;

import java.util.List;


/**
 * 考题表(Question)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-22 21:42:25
 */
public interface QuestionMapper extends BaseMapper<Question> {
    List<QuestionInfoVo> getQuestionListByCourseId(Long courseId);
}

