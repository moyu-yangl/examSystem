package com.examSystem.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseVo {
    //课程id
    private Long courseId;

    private String userName;
    //用户id 外键
    private Long userId;
    //课程名称
    private String courseName;
    //开课老师名称
    private String teacherName;
    //课程状态 0是未发布考试，1是已经发布考试
    private String state;
}
