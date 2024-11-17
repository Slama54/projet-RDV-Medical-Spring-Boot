package com.app.rdv.service;

import com.app.rdv.entities.Medecin;
import com.app.rdv.entities.Patient;
import com.app.rdv.entities.Rdv;

import java.time.LocalDateTime;
import java.util.List;

public interface IServiceRdv {

    Rdv createRdv(Rdv rdv);
    List<Rdv> readAllRdv();
    Rdv GetRdvByMedecinAndDateRdv(Medecin medecin, LocalDateTime dateRdv);
    Rdv GetRdvByPatientAndDateRdv(Patient patient, LocalDateTime dateRdv);
    List<Rdv> GetAllByDateRdv();




}
