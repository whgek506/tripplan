package com.project.tripplan.schedule.controller;

import com.project.tripplan.schedule.dto.ScheduleDto;
import com.project.tripplan.schedule.dto.ScheduleInsertDto;
import com.project.tripplan.schedule.dto.ScheduleUpdateDto;
import com.project.tripplan.schedule.entity.Schedule;
import com.project.tripplan.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    //일정 등록
    @PostMapping("/post")
    public ResponseEntity<String> saveSchedule(@RequestBody ScheduleInsertDto dto) {

//        ScheduleDto scheduleDto = ScheduleDto.builder()
//                .scheduleTitle(dto.getScheduleTitle())
//                .startTime(dto.getStartTime())
//                .endTime(dto.getEndTime())
//                .scheduleCategory(dto.getScheduleCategory())
//                .scheduleMemo(dto.getScheduleMemo())
//                .scheduleLink(dto.getScheduleLink())
//                .scheduleLinkTitle(dto.getScheduleTitle())
//                .build();

        scheduleService.saveSchedule(dto.getPlanId(), dto);

        return ResponseEntity.ok("등록 완료");
    }

    //일정 조회
    @GetMapping("/{planId}")
    public ResponseEntity<?> findAllSchedule(@PathVariable Long planId) {
        List<ScheduleDto> scheduleDtoList = scheduleService.findAllSchedule(planId);

        return ResponseEntity.ok().body(scheduleDtoList);
    }

    //일정 수정
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSchedule(@PathVariable Long id,
                                                 @RequestBody ScheduleUpdateDto dto) {

//        ScheduleDto scheduleDto = ScheduleDto.builder()
//                .startTime(dto.getStartTime())
//                .endTime(dto.getEndTime())
//                .scheduleCategory(dto.getScheduleCategory())
//                .scheduleMemo(dto.getScheduleMemo())
//                .scheduleLink(dto.getScheduleLink())
//                .scheduleLinkTitle(dto.getScheduleTitle())
//                .build();

        scheduleService.updateSchedule(id, dto);

        return ResponseEntity.ok("수정 완료");
    }

    //일정 삭제
    @DeleteMapping("/{id}")
    public boolean deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);

        return true;
    }
}
