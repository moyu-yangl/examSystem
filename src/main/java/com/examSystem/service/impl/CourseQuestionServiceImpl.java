package com.examSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examSystem.domain.entity.CourseQuestion;
import com.examSystem.mapper.CourseQuestionMapper;
import com.examSystem.service.CourseQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程-考题表(CourseQuestion)表服务实现类
 *
 * @author makejava
 * @since 2023-02-23 10:58:30
 */
@Service("courseQuestionService")
public class CourseQuestionServiceImpl extends ServiceImpl<CourseQuestionMapper, CourseQuestion> implements CourseQuestionService {

    @Override
    public List<Long> selectAllByCourseId(Long courseId) {

        return baseMapper.selectAllByCourseId(courseId);
    }
}

