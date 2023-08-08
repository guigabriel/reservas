package com.ibm.ibmproject.controller;

import com.ibm.ibmproject.domain.Reservation;
import com.ibm.ibmproject.dto.ReservationDto;
import com.ibm.ibmproject.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/reservas")
@CrossOrigin(origins = "http://localhost:4200")
public class ReservationController {

    @Autowired
    private ReservationService service;

    @PostMapping
    public ResponseEntity<Reservation> insert(@RequestBody ReservationDto dto) {
        Reservation result = service.insert(dto.transformToDto());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(uri).body(result);
    }
    @GetMapping
    public ResponseEntity<List<Reservation>> findAll() {
        List<Reservation> result = service.findAll();
        return ResponseEntity.ok().body(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> findById(@PathVariable Integer id) {
        Reservation result = service.findById(id);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> update(@PathVariable Integer id, @RequestBody ReservationDto reserva) {
        Reservation result = service.update(id, reserva.transformToDto());
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}/cancelar")
    public ResponseEntity<Reservation> delete(@PathVariable Integer id) {
        Reservation result = service.delete(id);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/confirmadas")
    public ResponseEntity<List<Reservation>> findAllConfirmed(){
        List<Reservation> confirmadas = service.findAllConfirmed();
        return ResponseEntity.ok().body(confirmadas);
    }
    @GetMapping("/pendentes")
    public ResponseEntity<List<Reservation>> findAllPending(){
        List<Reservation> pendentes = service.findAllPending();
        return ResponseEntity.ok().body(pendentes);
    }
    @GetMapping("/canceladas")
    public ResponseEntity<List<Reservation>> findAllCanceled(){
        List<Reservation> canceladas = service.findAllCanceled();
        return ResponseEntity.ok().body(canceladas);
    }

}
