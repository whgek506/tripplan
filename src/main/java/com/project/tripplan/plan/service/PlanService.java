package com.project.tripplan.plan.service;

import com.project.tripplan.plan.dto.PlanDto;
import com.project.tripplan.plan.dto.PlanReponseDto;
import com.project.tripplan.plan.dto.PlanUpdateDto;
import com.project.tripplan.plan.entity.City;
import com.project.tripplan.plan.entity.Plan;
import com.project.tripplan.plan.repository.CityRepository;
import com.project.tripplan.plan.repository.PlanRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PlanService {
    private final PlanRespository planRespository;
    private final CityRepository cityRepository;

    //계획 등록
    @Transactional
    public void savePlans(PlanDto dto) {
       Optional<City> city = cityRepository.findByCityName(String.valueOf(dto.getCity()));
        if(city.isPresent()) {
            Plan plan = planRespository.save(Plan.builder()
                    .planTitle(dto.getPlanTitle())
                    .startDate(dto.getStartDate())
                    .endDate(dto.getEndDate())
                    .city(city.get())
                    .build());
        }
    }

    //계획 조회
    public List<PlanReponseDto> findAllPlans() {
        List<Plan> plans = planRespository.findAll();
        return plans.isEmpty() ? List.of() : plans.stream().map(PlanReponseDto::new).collect(Collectors.toList());
    }

    //계획 수정
    @Transactional
    public void updatePlan(Long id, PlanUpdateDto updateDto) {
        Plan plan = planRespository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not exist Carrot Data by id : [" + id + "]"));
        plan.updatePlan(updateDto.getPlanTitle(), updateDto.getStartDate(), updateDto.getEndDate());
    }

    //계획 삭제
    @Transactional
    public void deletePlan(Long id) {
        Plan plan = planRespository.findById(id).orElseThrow(() -> new IllegalArgumentException("Not exist Carrot Data by id : [" + id + "]"));

        planRespository.delete(plan);
    }
}
