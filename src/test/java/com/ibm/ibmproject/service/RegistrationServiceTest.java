package com.ibm.ibmproject.service;

import com.ibm.ibmproject.domain.Reservation;
import com.ibm.ibmproject.repository.ReservationRepository;
import com.ibm.ibmproject.service.exceptions.HospedeNomeException;
import com.ibm.ibmproject.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
 class RegistrationServiceTest {

    @Mock
    private ReservationRepository repository;

    @InjectMocks
    private ReservationService service;

    public Reservation reserva () throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Date inicio = format.parse("2023/08/22");
        Date fim = format.parse("2023/08/23");
        return new Reservation(1, "guilherme", inicio, fim, 4, "CONFIRMADA");
    }


    @Test
    void testInsertReservation() throws ParseException {
        Reservation reservaMock = reserva();
        when(repository.save(any(Reservation.class))).thenReturn(reservaMock);

        Reservation reservaInserida = service.insert(reservaMock);

        assertNotNull(reservaInserida);
        assertEquals(reservaMock.getNomeHospede(), reservaInserida.getNomeHospede());
        assertEquals(reservaMock.getDataInicio(), reservaInserida.getDataInicio());
        assertEquals(reservaMock.getDataFim(), reservaInserida.getDataFim());
        assertEquals(reservaMock.getQuantidadePessoas(), reservaInserida.getQuantidadePessoas());
        assertEquals(reservaMock.getStatus(), reservaInserida.getStatus());

        verify(repository, times(1)).save(any(Reservation.class));
    }

    @Test
    void testFindById() throws ParseException{
        Integer id = 1;
        Reservation reservaMock = reserva();
        when(repository.findById(id)).thenReturn(Optional.of(reservaMock));

        Reservation reservaEncontrada = service.findById(id);
        assertNotNull(reservaEncontrada);
        assertEquals(reservaMock.getNomeHospede(), reservaEncontrada.getNomeHospede());
        assertEquals(reservaMock.getDataInicio(), reservaEncontrada.getDataInicio());
        assertEquals(reservaMock.getDataFim(), reservaEncontrada.getDataFim());
        assertEquals(reservaMock.getQuantidadePessoas(), reservaEncontrada.getQuantidadePessoas());
        assertEquals(reservaMock.getStatus(), reservaEncontrada.getStatus());

        verify(repository, times(1)).findById(id);
    }

    @Test
    void testObjectNotFound() {
        Integer id = 99;

        when(repository.findById(id)).thenReturn(Optional.empty());
        assertThrows(ObjectNotFoundException.class, () -> service.findById(id));

        verify(repository, times(1)).findById(id);
    }

    @Test
    void testValidateReserva() {
        Throwable exception = assertThrows(HospedeNomeException.class, () -> {
            Reservation reservaMock = reserva();
            reservaMock.setNomeHospede("gui");
        });
        assertEquals("O nome do hóspede deve ter no mínimo 5 letras", exception.getMessage());
    }
//
//    @Test
//    void testDelete() throws ParseException {
//        Reservation reservaMock = reserva();
//        when(repository.save(any(Reservation.class))).thenReturn(reservaMock);
//        Reservation reservaInserida = service.insert(reservaMock);
//        assertNotNull(reservaInserida);
//        Integer id = reservaInserida.getId();
//
//        verify(repository, times(1)).save(id);
//    }


}
