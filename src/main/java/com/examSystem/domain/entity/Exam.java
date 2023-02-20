package com.examSystem.domain.entity;

import java.util.Date;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
/**
 * 考试表(Exam)表实体类
 *
 * @author makejava
 * @since 2023-02-20 10:22:55
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("exam")
public class Exam  {

    //课程id
    private Long courseId;
    //用户id
    private Long userId;
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
    //创建时间
    private Date createTime;
    //创建人
    private Long createBy;
    //更新人
    private Long updateBy;
    //更新时间
    private Date updateTime;
    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;



}

