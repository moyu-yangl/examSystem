package com.examSystem.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamInfoVo {

    //课程id
    private Long courseId;
    //用户id
    private Long examId;
    //考试名称
    private String examName;
    //开始时间
    private Date startTime;
    //结束时间
    private Date endTime;
    //所得分数
    private Integer score;
    //及格 0是未考 1及格 2不及格
    private String pass;
    //考试状态 0是未考 1是考试中途退出 2是考试结束
    private String state;
    //更新时间
    private Date updateTime;
    //开课老师
    private String teacherName;
    //课程名称
    private String courseName;


}
