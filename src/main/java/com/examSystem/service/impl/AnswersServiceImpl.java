package com.examSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examSystem.domain.entity.Answers;
import com.examSystem.mapper.AnswersMapper;
import com.examSystem.service.AnswersService;
import org.springframework.stereotype.Service;

/**
 * (Answers)表服务实现类
 *
 * @author makejava
 * @since 2023-02-23 21:53:06
 */
@Service("answersService")
public class AnswersServiceImpl extends ServiceImpl<AnswersMapper, Answers> implements AnswersService {

}

