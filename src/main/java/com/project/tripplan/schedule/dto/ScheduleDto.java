package com.project.tripplan.schedule.dto;

import com.project.tripplan.schedule.entity.Schedule;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
public class ScheduleDto {
    private Long scheduleId;
    private String scheduleTitle;
    private String scheduleMemo;
    private LocalTime startTime;
    private LocalTime endTime;
    private String scheduleCategory;
    private String scheduleLinkTitle;
    private String scheduleLink;

    public ScheduleDto(Schedule schedule) {
        this.scheduleId = schedule.getScheduleId();
        this.scheduleTitle = schedule.getScheduleTitle();
        this.scheduleMemo = schedule.getScheduleMemo();
        this.startTime = schedule.getStartTime();
        this.endTime = schedule.getEndTime();
        this.scheduleCategory = schedule.getScheduleCategory();
        this.scheduleLinkTitle = schedule.getScheduleLinkTitle();
        this.scheduleLink = schedule.getScheduleLink();
    }

    public ScheduleDto(String scheduleTitle, String scheduleMemo, LocalTime startTime, LocalTime endTime, String scheduleCategory, String scheduleLinkTitle, String scheduleLink) {
        this.scheduleTitle = scheduleTitle;
        this.scheduleMemo = scheduleMemo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.scheduleCategory = scheduleCategory;
        this.scheduleLinkTitle = scheduleLinkTitle;
        this.scheduleLink = scheduleLink;
    }
}
