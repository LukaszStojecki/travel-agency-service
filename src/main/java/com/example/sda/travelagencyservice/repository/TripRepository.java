package com.example.sda.travelagencyservice.repository;

import com.example.sda.travelagencyservice.model.City;
import com.example.sda.travelagencyservice.model.Continent;
import com.example.sda.travelagencyservice.model.Country;
import com.example.sda.travelagencyservice.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface TripRepository  extends JpaRepository<Trip,Long> {

    Trip getById(Long id);

    @Query("select t from Trip t where t.startDate>=:startDate and t.endDate<=:endDate")
    List<Trip> findTripByStartDateAndEndDate(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);

    List<Trip> findByArrivalCity(City city);

    List<Trip> findByArrivalCityCountry(Country country);
    List<Trip> findByArrivalCityCountryContinent(Continent continent);
}
