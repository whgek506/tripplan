package com.project.tripplan.plan.dto;

import com.project.tripplan.plan.entity.City;
import com.project.tripplan.plan.entity.Country;
import com.project.tripplan.plan.entity.Plan;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class PlanDto {
    private String planTitle;
    private LocalDate startDate;
    private LocalDate endDate;
    private String planImage;
    private City city;

}
