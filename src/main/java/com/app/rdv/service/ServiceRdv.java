package com.app.rdv.service;

import com.app.rdv.entities.Medecin;
import com.app.rdv.entities.Patient;
import com.app.rdv.entities.Rdv;
import com.app.rdv.repository.RdvRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ServiceRdv implements IServiceRdv{
    private final RdvRepository rdvRepository;
    @Override
    public Rdv createRdv(Rdv rdv) {
        Rdv existingRdvMedecin = rdvRepository.findRdvByMedecinAndDateRdv(rdv.getMedecin(),rdv.getDateRdv());
        Rdv existingRdvPatient = rdvRepository.findRdvByPatientAndDateRdv(rdv.getPatient(),rdv.getDateRdv());
        if (existingRdvMedecin==null && existingRdvPatient==null){
            return rdvRepository.save(rdv);
        }else {
            return null;
        }
    }
    @Override
    public List<Rdv> readAllRdv() {
        return rdvRepository.findAll();
    }

    @Override
    public Rdv GetRdvByMedecinAndDateRdv(Medecin medecin, LocalDateTime dateRdv) {
        return rdvRepository.findRdvByMedecinAndDateRdv(medecin,dateRdv);
    }
    @Override
    public Rdv GetRdvByPatientAndDateRdv(Patient patient, LocalDateTime dateRdv) {
        return rdvRepository.findRdvByPatientAndDateRdv(patient,dateRdv);
    }

    @Override
    public List<Rdv> GetAllByDateRdv() {
        return rdvRepository.findAllByOrderByDateRdvAsc();
    }




}
