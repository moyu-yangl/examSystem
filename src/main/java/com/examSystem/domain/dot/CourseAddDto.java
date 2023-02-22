package com.examSystem.domain.dot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseAddDto {

    //用户id 外键
    private Long userId;
    //课程名称
    private String courseName;

    private List<Long> studentIds;

}
