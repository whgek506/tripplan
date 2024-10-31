package com.project.tripplan.plan.entity;

import com.project.tripplan.schedule.entity.Schedule;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@AllArgsConstructor
@Builder
@Entity
@Getter
@Table(name = "plan")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plan_id")
    private Long planId;

    @Column(name = "plan_title")
    private String planTitle;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "plan_created")
    private LocalDateTime planCreated;

    @Column(name = "plan_image")
    private String planImage;

    @OneToMany(mappedBy = "plan", cascade = ALL)
    private List<Schedule> schedules = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;


    //비즈니스 로직
//    public void addPlan(String planTitle, LocalDate startDate, LocalDate endDate, LocalDateTime planCreated, String planImage) {
//        this.planTitle = planTitle;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.planCreated = LocalDateTime.now();
//        this.planImage = planImage;
//    }

    public void updatePlan(String planTitle, LocalDate startDate, LocalDate endDate) {
        this.planTitle = planTitle;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //저장되기 전 실행 메서드
    @PrePersist
    public void prePersist() {
        this.planCreated = LocalDateTime.now();
    }

}

