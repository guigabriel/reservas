package com.ibm.ibmproject.service;

import com.ibm.ibmproject.domain.Reservation;
import com.ibm.ibmproject.service.exceptions.HospedeNomeException;
import com.ibm.ibmproject.service.exceptions.QntMinException;

import static org.hibernate.query.sqm.tree.SqmNode.log;

 class ValidationService {

     private ValidationService() {

     }

     public static void validateReservation(Reservation reserva) {
         verificaQntPessoas(reserva.getQuantidadePessoas());
         verificaNomeDoHospede(reserva.getNomeHospede());
     }

    public static void verificaQntPessoas(Integer quantidade) {
        try {
            if(quantidade < 1) {
                throw new QntMinException("Quantidade de pessoas dever ser maior que 0 ");
            }
        }catch (Exception e) {
            log.error("Ocorreu um erro durante a realização da reserva: ", e );
            throw e;
        }
    }

    public static void verificaNomeDoHospede(String nome) {
       try {
           if(nome.length() < 5) {
                throw  new HospedeNomeException("O nome do hóspede deve ter no mínimo 5 letras");
           }
       }catch (Exception e) {
           log.error("Ocorreu um erro durante a realização da reserva", e);
           throw e;
       }
    }

}
