package com.examSystem.domain.dot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionUpdateDto {
    //课程id
    private Long courseId;
    //试题id
    private Long questionId;
    //x 选择题，t 填空题
    private String questionType;
    //题目内容
    private String context;
    //答案
    private String answer;
    //A选项
    private String optionA;
    //B选项
    private String optionB;
    //C选项
    private String optionC;
    //D选项
    private String optionD;
    //该题得分
    private Integer point;

}
