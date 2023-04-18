package com.proj.jpa_test.controllers;


import com.proj.jpa_test.entities.Patient;
import com.proj.jpa_test.repositories.IPatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


//@RestController
@Controller
@AllArgsConstructor
public class PatientController {


    private IPatientRepository patientrepo;

    @GetMapping(value = "/index")
    public String listPatients(Model model){
        List<Patient> patients = patientrepo.findAll();
        model.addAttribute("listPatient", patients);
        return "vue";
    }
}
