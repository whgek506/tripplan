package com.project.tripplan.schedule.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class ScheduleDto {
    private String scheduleTitle;
    private String scheduleMemo;
    private LocalTime startTime;
    private LocalTime endTime;
    private String scheduleCategory;

}
