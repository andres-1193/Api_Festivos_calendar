package com.example.api_calendar.aplicacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

import com.example.api_calendar.core.DTOs.FestivoDTO;
import com.example.api_calendar.core.entidades.Calendario;
import com.example.api_calendar.core.entidades.Tipo;
import com.example.api_calendar.core.interfaces.repositorios.ICalendarioRepositorio;
import com.example.api_calendar.core.interfaces.servicios.ICalendarioServicio;

@Service
public class CalendarioServicio implements ICalendarioServicio {
    private FestivoCliente festivoCliente;
    private ICalendarioRepositorio repositorio;

    
    public CalendarioServicio(FestivoCliente festivoCliente, ICalendarioRepositorio repositorio) {
        this.festivoCliente = festivoCliente;
        this.repositorio = repositorio;
    }

    @Override
    public List<FestivoDTO> obtenerFestivosAño(String año) {
        List<FestivoDTO> festivos = new ArrayList<>();
        int añoI = Integer.parseInt(año);
        LocalDate fechaInicio = LocalDate.of(añoI, 1, 1);
        LocalDate fechaFin = LocalDate.of(añoI, 12, 31);
        LocalDate fechaActual = fechaInicio;
        while (!fechaActual.isAfter(fechaFin)) {
            String resultado = festivoCliente.validarFestivo(añoI, fechaActual.getMonthValue(), fechaActual.getDayOfMonth());
            if (resultado.equals("Es Festivo")) {
                festivos.add(new FestivoDTO(" ", año + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getDayOfMonth()));
            }
            fechaActual = fechaActual.plusDays(1);
        }
        return festivos;
    }

    @Override
    public boolean clasificarAño(String año) {
        int añoI = Integer.parseInt(año);
        LocalDate fechaInicio = LocalDate.of(añoI, 1, 1);
        LocalDate fechaFin = LocalDate.of(añoI, 12, 31);
        LocalDate fechaActual = fechaInicio;
        while (!fechaActual.isAfter(fechaFin)) {
            String resultado = festivoCliente.validarFestivo(añoI, fechaActual.getMonthValue(), fechaActual.getDayOfMonth());
            if (resultado.equals("Es Festivo")) {
                guardar(new Calendario(0, año + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getDayOfMonth(), "Es Festivo", new Tipo(3, " ")));
            } else {
                if (fechaActual.getDayOfWeek().getValue() <= 5) {
                    guardar(new Calendario(0, año + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getDayOfMonth(), "Dia Laboral", new Tipo(1, " ")));
                } else {
                    guardar(new Calendario(0, año + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getDayOfMonth(), "Fin de Semana", new Tipo(2, " ")));
                }
            }
            fechaActual = fechaActual.plusDays(1);
        }
        return true;
    }

    @Override
    public Calendario guardar(Calendario calendario) {
        return repositorio.save(calendario);
    }

    
    @Override
    public List<Calendario> listar() {
        return repositorio.findAll();
    }
}
