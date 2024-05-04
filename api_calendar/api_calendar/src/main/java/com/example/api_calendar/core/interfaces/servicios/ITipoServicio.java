package com.example.api_calendar.core.interfaces.servicios;

import java.util.List;

import com.example.api_calendar.core.DTOs.FestivoDTO;

public interface ITipoServicio {
 public List<FestivoDTO> obtenerFstivos(String año);
}
