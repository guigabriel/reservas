package com.ibm.ibmproject.controller;

import com.ibm.ibmproject.domain.Reservation;
import com.ibm.ibmproject.service.ReservationService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.text.SimpleDateFormat;

import java.util.Date;



import static org.hamcrest.Matchers.hasSize;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(ReservationController.class)
class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReservationService reservationService;

    @InjectMocks
    private ReservationController reservationController;
    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
    @Test
    void testInsertReservation() throws Exception {
        Date inicio = format.parse("2023/08/22");
        Date fim = format.parse("2023/08/23");
        Reservation reserva = new Reservation();

        when(reservationService.insert(any(Reservation.class))).thenReturn(reserva);

        mockMvc.perform(MockMvcRequestBuilders.post("/reservas")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"nomeHospede\":\"guilherme\",\"dataInicio\":\"2023-08-22\",\"dataFim\":\"2023-08-23\",\"quantidadePessoas\":4,\"status\":\"CONFIRMADA\"}"))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.header().string("Location", "http://localhost/reservas/"));
    }

    @Test
    void testDeleteReservation() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/reservas/1/cancelar"))
                .andExpect(status().isOk());
    }

    @Test
    void testFindReservation() throws Exception{
        Integer id = 1;
        Date inicio = format.parse("2023/08/22");
        Date fim = format.parse("2023/08/23");
        Reservation reservaEncontrada = new Reservation(id, "João", inicio, fim, 4, "CONFIRMADA");

        when(reservationService.findById(id)).thenReturn(reservaEncontrada);

        mockMvc.perform(MockMvcRequestBuilders.get("/reservas/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nomeHospede").value("João"))
                .andExpect(jsonPath("$.quantidadePessoas").value(4));
    }

    @Test
    void testFindAll() throws Exception {
       mockMvc.perform(MockMvcRequestBuilders.get("/reservas"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(jsonPath("$").isArray());

    }

}
