package com.examSystem.domain.dot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    private Long courseId;
    private Long examId;
    private Long userId;
    private List<QuestionDto> questions;
}
