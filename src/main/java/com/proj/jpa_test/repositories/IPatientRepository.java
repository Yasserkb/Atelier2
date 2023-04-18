package com.proj.jpa_test.repositories;

import com.proj.jpa_test.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import java.util.List;

public interface IPatientRepository extends JpaRepository<Patient,Long> {
//    List<Patient> findByMalade(boolean m);

//    Page<Patient> findAll();
    Page<Patient> findByMalade(boolean m, Pageable pageable);

    @Query("select p from Patient p where p.nom like :x")
    Page<Patient> chercherPatients(@Param("x")String mc,Pageable pageable);

    @Query("select p from Patient p where p.nom like :x and p.score<:y")
    List<Patient> chercherPatient(@Param("x") String nom, @Param("y") int scoreMin);

}
