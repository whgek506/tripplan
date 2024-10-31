package com.project.tripplan.plan.repository;

import com.project.tripplan.plan.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRespository extends JpaRepository<Plan, Long> {
}
