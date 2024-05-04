package com.example.api_calendar.aplicacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class FestivoCliente {

    @Autowired
    private RestTemplate restTemplate;
  
     public String validarFestivo(int año, int mes, int dia) {
        String url = "http://localhost:3030/festivos/verificar/" + año +"/"+mes+"/"+dia;
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<String>() {

                });
        return responseEntity.getBody();
    }
}
