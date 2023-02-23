package com.examSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.examSystem.domain.entity.CourseQuestion;

import java.util.List;


/**
 * 课程-考题表(CourseQuestion)表服务接口
 *
 * @author makejava
 * @since 2023-02-23 10:58:29
 */
public interface CourseQuestionService extends IService<CourseQuestion> {
    List<Long> selectAllByCourseId(Long courseId);
}

