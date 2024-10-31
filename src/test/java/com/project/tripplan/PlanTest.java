package com.project.tripplan;

import com.project.tripplan.plan.entity.City;
import com.project.tripplan.plan.entity.Plan;
import com.project.tripplan.plan.repository.CityRepository;
import com.project.tripplan.plan.repository.PlanRespository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class PlanTest {

    @Autowired
    private PlanRespository planRespository;
    @Autowired
    private CityRepository cityRepository;

    @Test
    void save() {
        String cityName = "오사카";

        Optional<City> city = cityRepository.findByCityName(cityName);
        //Optional<City> city = cityRepository.findByCityName(String.valueOf(dto.getCity()));

        Plan save = Plan.builder()
                .planTitle("나 혼자 떠나는 여행")
                .startDate(LocalDate.of(2024, 11, 1))
                .endDate(LocalDate.of(2024, 11, 1))
                .city(city.get())
                .planImage("")
                .build();
    }

}
