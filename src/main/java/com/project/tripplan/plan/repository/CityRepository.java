package com.project.tripplan.plan.repository;

import com.project.tripplan.plan.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    //Optional<City> findByCityName(City city);

    @Modifying
    @Query("select c.cityName from City c where c.cityName = :city")
    Optional<City> findByCityName(String city);
}
