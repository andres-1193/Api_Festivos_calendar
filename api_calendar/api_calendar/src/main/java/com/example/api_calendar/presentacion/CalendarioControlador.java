package com.example.api_calendar.presentacion;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_calendar.core.DTOs.FestivoDTO;
import com.example.api_calendar.core.entidades.Calendario;
import com.example.api_calendar.core.interfaces.servicios.ICalendarioServicio;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioControlador {
    private ICalendarioServicio servicio;

    public CalendarioControlador(ICalendarioServicio servicio) {
        this.servicio = servicio;
    }

    @RequestMapping(value = "/festivos/{año}", method = RequestMethod.GET)
    public List<FestivoDTO> obtener(@PathVariable String año) {
        return servicio.obtenerFestivosAño(año);
    }

    @RequestMapping(value = "/clasificar/{año}", method = RequestMethod.GET)
    public boolean clasificar(@PathVariable String año) {
        return servicio.clasificarAño(año);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Calendario> listarCalendario() {
        return servicio.listar();
    }
}
