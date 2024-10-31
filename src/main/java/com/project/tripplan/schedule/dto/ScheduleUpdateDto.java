package com.project.tripplan.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class ScheduleUpdateDto {
    private String scheduleTitle;
    private String scheduleMemo;
    private LocalTime startTime;
    private LocalTime endTime;
    private String scheduleCategory;
    private String scheduleLinkTitle;
    private String scheduleLink;
}
