package miu.cs.ads_datapersisitence.controller;

import miu.cs.ads_datapersisitence.model.Patient;
import miu.cs.ads_datapersisitence.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ads/api/v1/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/")
    public List<Patient> getAllPatient() {
        return patientService.getAllPatient();
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable(value = "id") Integer id) {
        return patientService.getPatient(id);
    }

    @GetMapping("/search/{query}")
    public List<Patient> searchPatient(@PathVariable String query) {
        return patientService.searchPatient(query);
    }

    @PostMapping("/")
    public void addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable(value = "id") Integer id, @RequestBody Patient patient) {
        return patientService.updatePatient(id,patient);
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable(value = "id") Integer id) {
        patientService.deletePatient(id);
    }
}