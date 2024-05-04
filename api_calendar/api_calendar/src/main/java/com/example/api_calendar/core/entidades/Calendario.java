package com.example.api_calendar.core.entidades;
  
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 
import jakarta.persistence.JoinColumn; 
import jakarta.persistence.ManyToOne; 
import jakarta.persistence.Table;
@Entity 
@Table(name = "calendario")
public class Calendario {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_calendario_seq")
    @GenericGenerator(name = "id_calendario_-seq", strategy = "increment")
    private long id;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idTipo", referencedColumnName = "id")
    private Tipo tipo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Calendario(long id, String fecha, String descripcion, Tipo tipo) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }
}
