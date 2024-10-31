package com.project.tripplan.schedule.repository;

import com.project.tripplan.schedule.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    //시간이 빠른 순서대로 오름차순 정렬
    @Query("select s from Schedule s where s.plan.planId = :planId order by s.startTime")
    List<Schedule> findAllSchedule(@Param("planId") Long planId);
}
