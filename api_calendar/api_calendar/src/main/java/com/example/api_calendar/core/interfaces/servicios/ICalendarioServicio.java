package com.example.api_calendar.core.interfaces.servicios;

import java.util.List;
import com.example.api_calendar.core.DTOs.FestivoDTO;
import com.example.api_calendar.core.entidades.Calendario;

public interface ICalendarioServicio {

    List<FestivoDTO> obtenerFestivosAño(String año);

    boolean clasificarAño(String año);

    Calendario guardar(Calendario calendario);

    List<Calendario> listar();
}
