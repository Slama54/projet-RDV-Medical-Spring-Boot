package com.app.rdv.repository;

import com.app.rdv.entities.Medecin;
import com.app.rdv.entities.Patient;
import com.app.rdv.entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RdvRepository extends JpaRepository<Rdv, Integer> {



    public Rdv findRdvByMedecinAndDateRdv(Medecin medecin, LocalDateTime dateRdv);
    public Rdv findRdvByPatientAndDateRdv(Patient patient, LocalDateTime dateRdv);
    List<Rdv> findAllByOrderByDateRdvAsc();



}
