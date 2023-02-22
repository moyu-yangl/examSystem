package com.examSystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.examSystem.domain.entity.Exam;
import com.examSystem.mapper.ExamMapper;
import com.examSystem.service.ExamService;
import org.springframework.stereotype.Service;

/**
 * 考试表(Exam)表服务实现类
 *
 * @author makejava
 * @since 2023-02-22 14:24:38
 */
@Service("examService")
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {

}

