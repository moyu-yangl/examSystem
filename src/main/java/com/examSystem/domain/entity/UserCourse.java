package com.examSystem.domain.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (UserCourse)表实体类
 *
 * @author makejava
 * @since 2023-02-22 20:17:52
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_course")
public class UserCourse {


    private Long courseId;

    private Long userId;

    private String courseName;

    private String userName;

    private Integer delFlag;


}

