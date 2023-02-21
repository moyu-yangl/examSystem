package com.examSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examSystem.domain.ResponseResult;
import com.examSystem.domain.entity.Course;
import com.examSystem.domain.vo.CourseVo;
import com.examSystem.domain.vo.PageVo;
import com.examSystem.mapper.CourseMapper;
import com.examSystem.service.CourseService;
import com.examSystem.utils.SecurityContextUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课程表(Course)表服务实现类
 *
 * @author makejava
 * @since 2023-02-21 20:06:30
 */
@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Override
    public ResponseResult listCourse(Integer pageNum, Integer pageSize) {
        Long userId = SecurityContextUtils.getUserId();
        List<CourseVo> courseVos = baseMapper.listAllByUserId(userId, (pageNum - 1) * pageSize, pageSize);
        PageVo pageVo = new PageVo(courseVos, (long) courseVos.size());
        return ResponseResult.okResult(pageVo);
    }
}

