package com.project.tripplan.plan.controller;

import com.project.tripplan.plan.dto.PlanDto;
import com.project.tripplan.plan.dto.PlanReponseDto;
import com.project.tripplan.plan.dto.PlanUpdateDto;
import com.project.tripplan.plan.entity.Plan;
import com.project.tripplan.plan.service.PlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
@RequiredArgsConstructor
public class PlanController {
    private final PlanService planService;

    //계획 등록
    @PostMapping("/post")
    public ResponseEntity<String> savePlans(@ModelAttribute PlanDto dto) {
        planService.savePlans(dto);

        return ResponseEntity.ok("등록 완료");
    }

    //전체 목록 조회
    @GetMapping("/my")
    public ResponseEntity<?> findAllPlans() {
        List<PlanReponseDto> planDtoList = planService.findAllPlans();

        //log.info("plan {}", planDtoList);

        return ResponseEntity.ok().body(planDtoList);
    }

    //계획 수정
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePlan(@PathVariable Long id,
                                        @ModelAttribute PlanUpdateDto updateDto) {
        planService.updatePlan(id, updateDto);

        return ResponseEntity.ok().build();
    }

    //계획 삭제
    @DeleteMapping("/{id}")
    public boolean deletePlan(@PathVariable Long id) {
       planService.deletePlan(id);

        return true;
    }
}
