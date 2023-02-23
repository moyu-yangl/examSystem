package com.examSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.entity.Question;
import com.examSystem.domain.vo.QuestionInfoVo;
import com.examSystem.mapper.QuestionMapper;
import com.examSystem.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 考题表(Question)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 21:42:26
 */
@Service("questionService")
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Override
    public ResponseResult getQuestionByCourseId(Long courseId) {
        List<QuestionInfoVo> list = baseMapper.getQuestionListByCourseId(courseId);
        return ResponseResult.okResult(list);
    }
}

