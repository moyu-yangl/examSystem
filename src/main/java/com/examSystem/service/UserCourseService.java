package com.examSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.examSystem.domain.entity.UserCourse;

import java.util.List;


/**
 * (UserCourse)表服务接口
 *
 * @author makejava
 * @since 2023-02-22 20:02:22
 */
public interface UserCourseService extends IService<UserCourse> {

    List<UserCourse> listByCourseId(Long courseId);
}

