package com.examSystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examSystem.domain.entity.UserCourse;
import com.examSystem.mapper.UserCourseMapper;
import com.examSystem.service.UserCourseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (UserCourse)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 20:02:22
 */
@Service("userCourseService")
public class UserCourseServiceImpl extends ServiceImpl<UserCourseMapper, UserCourse> implements UserCourseService {

    @Override
    public List<UserCourse> listByCourseId(Long courseId) {
        LambdaQueryWrapper<UserCourse> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserCourse::getCourseId, courseId);
        return list(queryWrapper);
    }
}

