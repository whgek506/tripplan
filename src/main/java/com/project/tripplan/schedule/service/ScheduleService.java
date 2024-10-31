package com.project.tripplan.schedule.service;

import com.project.tripplan.plan.entity.Plan;
import com.project.tripplan.plan.repository.PlanRespository;
import com.project.tripplan.schedule.dto.ScheduleDto;
import com.project.tripplan.schedule.dto.ScheduleInsertDto;
import com.project.tripplan.schedule.dto.ScheduleUpdateDto;
import com.project.tripplan.schedule.entity.Schedule;
import com.project.tripplan.schedule.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final PlanRespository planRespository;

    //일정 등록
    public void saveSchedule(Long planId, ScheduleInsertDto dto) {

        Plan plan = planRespository.findById(planId).orElseThrow(() -> new IllegalArgumentException("Invalid Plan ID"));
        Schedule schedule = Schedule.createSchedule(plan, new ScheduleDto(dto.getScheduleTitle(), dto.getScheduleMemo(), dto.getStartTime(), dto.getEndTime(), dto.getScheduleCategory(), dto.getScheduleLinkTitle(), dto.getScheduleLink()));
        scheduleRepository.save(schedule);
    }

    //일정 조회
    public List<ScheduleDto> findAllSchedule(Long planId) {
        return scheduleRepository.findAllSchedule(planId)
                .stream()
                .map(ScheduleDto::new)
                .collect(Collectors.toList());
    }

    //일정 수정
    public void updateSchedule(Long id, ScheduleUpdateDto dto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Schedule ID"));
        schedule.addSchedule(dto.getScheduleTitle(), dto.getScheduleMemo(), dto.getStartTime(), dto.getEndTime(),
                dto.getScheduleCategory(), dto.getScheduleLink(), dto.getScheduleLinkTitle());
    }

    //일정 삭제
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
