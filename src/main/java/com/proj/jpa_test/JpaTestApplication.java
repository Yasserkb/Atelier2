package com.proj.jpa_test;

import com.proj.jpa_test.entities.Patient;
import com.proj.jpa_test.repositories.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaTestApplication implements CommandLineRunner {
    @Autowired
    public IPatientRepository patientRepository;
    public static void main(String[] args) {
        SpringApplication.run(JpaTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        for (int i = 0; i < 100; i++){
//            patientRepository.save(new Patient(null,"kouba",new Date(),Math.random()>0.5?true:false,(int)(Math.random()*100)));
//        }
//        patientRepository.save(new Patient(null,"kouba",new Date(),false,56));
//        patientRepository.save(new Patient(null,"ahmed",new Date(),true,85));
//        patientRepository.save(new Patient(null,"reda",new Date(),false,12));

        // update :
        Patient newpat = patientRepository.findById(8L).orElse(null);
        newpat.setScore(200);
        patientRepository.save(newpat);
        // delete :
//        patientRepository.deleteById(10L);
        patientRepository.deleteById(9L);
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(1,5));
        System.out.println("Total pages : " + patients.getTotalPages());
        System.out.println("Total elements : "+patients.getTotalElements());
        System.out.println("Num pages : " + patients.getNumber());
        List<Patient> content = patients.getContent();
        Page<Patient> byMalade = patientRepository.findByMalade(true, PageRequest.of(0,4));
        byMalade.forEach(p->{
            System.out.println("=============================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
            System.out.println(p.getScore());
        });
        patients.forEach(p->{
            System.out.println("=============================");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
            System.out.println(p.getScore());
        });
        System.out.println("*********************************");
        List<Patient> serPatient = patientRepository.chercherPatient("%k%",80);
        serPatient.forEach(p->{
            System.out.println("-=--=-=-=-=-=-=-=-=-=-");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());
            System.out.println(p.getScore());
        });
//        Patient patient = patientRepository.findById(1L).orElse(null);
//        if (patient!=null){
//            System.out.println(patient.getNom());
//            System.out.println(patient.getDateNaissance());
//            System.out.println(patient.isMalade());
//            System.out.println(patient.getScore());
//        }
//        patient.setScore(820);
//        patientRepository.save(patient);
//        patientRepository.deleteById(1L);
    }
}
