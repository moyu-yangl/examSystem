package com.examSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examSystem.domain.entity.UserExam;
import com.examSystem.mapper.UserExamMapper;
import com.examSystem.service.UserExamService;
import org.springframework.stereotype.Service;

/**
 * 用户考试表(UserExam)表服务实现类
 *
 * @author makejava
 * @since 2023-02-23 15:01:37
 */
@Service("userExamService")
public class UserExamServiceImpl extends ServiceImpl<UserExamMapper, UserExam> implements UserExamService {

}

