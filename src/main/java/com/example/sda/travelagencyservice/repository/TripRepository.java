package com.example.sda.travelagencyservice.repository;

import com.example.sda.travelagencyservice.dto.TripDto;
import com.example.sda.travelagencyservice.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TripRepository  extends JpaRepository<Trip,Long> {

    Trip getById(Long id);

    @Query("select t from Trip t where t.startDate>=:startDate and t.endDate<=:endDate")
    List<Trip> findTripByStartDateAndEndDate(@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);

}
