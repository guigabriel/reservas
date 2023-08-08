package com.ibm.ibmproject.service;

import com.ibm.ibmproject.domain.Reservation;
import com.ibm.ibmproject.repository.ReservationRepository;
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

    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

    @Test
    void testInsertReservation() throws ParseException {
        Date inicio = format.parse("2023/08/22");
        Date fim = format.parse("2023/08/23");
        Reservation reserva = new Reservation(1, "gui", inicio, fim, 4, "CONFIRMADA");
        when(repository.save(any(Reservation.class))).thenReturn(reserva);

        Reservation reservaInserida = service.insert(reserva);

        assertNotNull(reservaInserida);
        assertEquals(reserva.getNomeHospede(), reservaInserida.getNomeHospede());
        assertEquals(reserva.getDataInicio(), reservaInserida.getDataInicio());
        assertEquals(reserva.getDataFim(), reservaInserida.getDataFim());
        assertEquals(reserva.getQuantidadePessoas(), reservaInserida.getQuantidadePessoas());
        assertEquals(reserva.getStatus(), reservaInserida.getStatus());

        verify(repository, times(1)).save(any(Reservation.class));
    }

}
