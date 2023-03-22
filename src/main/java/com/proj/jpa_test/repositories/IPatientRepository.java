package com.proj.jpa_test.repositories;

import com.proj.jpa_test.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface IPatientRepository extends JpaRepository<Patient,Long> {
//    public List<Patient> findByMalade(boolean m);
    Page<Patient> findByMalade(boolean m, Pageable pageable);
//    @Query("select p from Patient p where p.dateNaissance between :x and :y or p.nom like :z")
//    List<Patient> chercherPatient(@Param("x") Date d1,@Param("y") Date d2 , @Param("z") String nom);

}
