package com.project.tripplan.plan.dto;

import com.project.tripplan.plan.entity.City;
import com.project.tripplan.plan.entity.Country;
import com.project.tripplan.plan.entity.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class PlanReponseDto {
    private String planTitle;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime planCreated;
    private String planImage;
    private String cityName;
    private String countryName;
    private String airport;

    public PlanReponseDto(Plan plan) {
        this.planTitle = plan.getPlanTitle();
        this.startDate = plan.getStartDate();
        this.endDate = plan.getEndDate();
        this.planCreated = plan.getPlanCreated();
        this.cityName = plan.getCity().getCityName();
        this.countryName = plan.getCity().getCountry().getCountryName();
        this.airport = plan.getCity().getAirport();
    }
}
