package com.examSystem.domain.dot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamAddDto {
    private String startTime;
    private String endTime;
    private Long courseId;
    private String examName;
}
