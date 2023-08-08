package com.ibm.ibmproject.repository;

import com.ibm.ibmproject.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

//    @Query("SELECT r FROM Reservation r WHERE r.id = :id AND r.status IN ('CONFIRMADA')")
//    Reservation specificUpdate(Integer id);
    @Query("SELECT r FROM Reservation r WHERE r.id = :id AND r.status IN ('CONFIRMADA', 'PENDENTE')")
    Reservation specificDelete(Integer id);

    @Query("SELECT r FROM Reservation r WHERE r.status = 'CONFIRMADA' ")
    List<Reservation> findAllConfirmed();

    @Query("SELECT r FROM Reservation r WHERE r.status = 'PENDENTE' ")
    List<Reservation> findAllPending();

    @Query("SELECT r FROM Reservation r WHERE r.status = 'CANCELADA' ")
    List<Reservation> findAllCanceled();

}
