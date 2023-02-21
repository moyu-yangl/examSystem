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
}
