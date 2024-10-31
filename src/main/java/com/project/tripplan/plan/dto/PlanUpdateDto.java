package com.project.tripplan.plan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class PlanUpdateDto {
    private String planTitle;
    private LocalDate startDate;
    private LocalDate endDate;
    private String planImage;
}
