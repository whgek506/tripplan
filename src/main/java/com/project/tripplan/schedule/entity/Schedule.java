package com.project.tripplan.schedule.entity;

import com.project.tripplan.plan.entity.Plan;
import com.project.tripplan.schedule.dto.ScheduleDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long scheduleId;

    @Column(name = "schedule_title")
    private String scheduleTitle;

    @Column(name = "schedule_memo")
    private String scheduleMemo;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "schedule_category")
    private String scheduleCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;

    //연관 관계 메서드
    public void addPlan(Plan plan) {
        this.plan = plan;
        plan.getSchedules().add(this);
    }

    public void addSchedule(String scheduleTitle, String scheduleMemo, LocalTime startTime, LocalTime endTime, String scheduleCategory) {
        this.scheduleTitle = scheduleTitle;
        this.scheduleMemo = scheduleMemo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.scheduleCategory = scheduleCategory;
    }

    //생성 메서드
    public static Schedule createSchedule(Plan plan, ScheduleDto scheduleDto) {
        Schedule schedule = new Schedule();
        schedule.addPlan(plan);
        schedule.addSchedule(scheduleDto.getScheduleTitle(), scheduleDto.getScheduleMemo(), scheduleDto.getStartTime(), scheduleDto.getEndTime(), scheduleDto.getScheduleCategory());

        return schedule;
    }

}
