package com.aakash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aakash.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	@Query(value = "SELECT * FROM doctor d where d_id = :id and d.available_date = :availableDate "
			+ "and TIME_FORMAT(d.available_date_start, '%H:%i') <= :availableDateStart "
			+ "and TIME_FORMAT(available_date_end, '%H:%i') >= :availableDateStart", nativeQuery = true)
	public List<Doctor> getDoctorsAvailability(@Param(value = "id") long doctor,
			@Param(value = "availableDate") String aptDate, @Param(value = "availableDateStart") String startTime);

}
