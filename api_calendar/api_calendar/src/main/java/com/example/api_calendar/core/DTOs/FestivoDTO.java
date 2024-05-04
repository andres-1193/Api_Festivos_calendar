package com.example.api_calendar.core.DTOs;

public class FestivoDTO {
    private String festivo;
    private String fecha;
    public FestivoDTO(String festivo, String fecha) {
        this.festivo = festivo;
        this.fecha = fecha;
    }
    public String getFestivo() {
        return festivo;
    }
    public void setFestivo(String festivo) {
        this.festivo = festivo;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
