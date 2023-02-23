package com.examSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.examSystem.domain.entity.CourseQuestion;

import java.util.List;


/**
 * 课程-考题表(CourseQuestion)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-23 10:58:25
 */
public interface CourseQuestionMapper extends BaseMapper<CourseQuestion> {
    List<Long> selectAllByCourseId(Long courseId);
}

