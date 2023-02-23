package com.examSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.examSystem.domain.entity.Exam;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 考试表(Exam)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-22 14:24:38
 */
public interface ExamMapper extends BaseMapper<Exam> {
    List<Exam> listAllByUserId(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("userId") Long userId, @Param("courseId") Long id);

    List<Exam> listAllByCourseId(Long courseId);
}

