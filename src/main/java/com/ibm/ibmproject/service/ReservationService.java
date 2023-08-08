package com.ibm.ibmproject.service;

import com.ibm.ibmproject.domain.Reservation;
import com.ibm.ibmproject.repository.ReservationRepository;
import com.ibm.ibmproject.service.exceptions.ObjectNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public Reservation insert(Reservation reserva) {
        ValidationService.validateReservation(reserva);
        reserva.setStatus("confirmada");
        return repository.save(reserva);
    }

    public List<Reservation> findAll() {
        return repository.findAll();
    }

    public Reservation findById(Integer id) {
        Optional<Reservation> result = repository.findById(id);
        return result.orElseThrow(() -> new ObjectNotFoundException("Object not Found"));
    }

    public Reservation update(Integer id, Reservation reserva) {
        Reservation find = findById(id);
        ValidationService.validateReservation(reserva);
        find.setNomeHospede(reserva.getNomeHospede());
        find.setDataInicio(reserva.getDataInicio());
        find.setDataFim(reserva.getDataFim());
        find.setQuantidadePessoas(reserva.getQuantidadePessoas());
        find.setStatus("pendente");
        return repository.save(find);
    }

    @Transactional
    public Reservation delete(Integer id) {
        findById(id);
        Reservation find = repository.specificDelete(id);
        find.setStatus("cancelada");
        return repository.save(find);
    }

    public List<Reservation> findAllPending(){
        return repository.findAllPending();
    }

    public List<Reservation> findAllConfirmed() {
        return repository.findAllConfirmed();
    }

    public List<Reservation> findAllCanceled() {
        return repository.findAllCanceled();
    }
}
