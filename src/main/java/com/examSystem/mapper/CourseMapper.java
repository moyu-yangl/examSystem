package com.examSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.examSystem.domain.entity.Course;
import com.examSystem.domain.vo.CourseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 课程表(Course)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-21 20:08:23
 */
public interface CourseMapper extends BaseMapper<Course> {
    List<CourseVo> listAllByUserId(@Param("userId") Long userId, @Param("start") Integer start, @Param("pageSize") Integer pageSize);
}

