package com.ibm.ibmproject.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ibm.ibmproject.domain.Reservation;

import java.util.Date;


public class ReservationDto {

    private String nomeHospede;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataInicio;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dataFim;

    private Integer quantidadePessoas;

    public Reservation transformToDto() {
        return new Reservation(nomeHospede, dataInicio, dataFim, quantidadePessoas);
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public Integer getQuantidadePessoas() {
        return quantidadePessoas;
    }
}
