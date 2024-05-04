package com.example.api_calendar.core.entidades;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity; 
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 
import jakarta.persistence.Id; 

import jakarta.persistence.Table;
@Entity 
@Table(name = "tipo")
public class Tipo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "id_tipo_seq")
    @GenericGenerator(name = "id_tipo_seq", strategy = "increment")
    private long id;

    @Column(name = "tipo")
    private String tipo;

    public Tipo(long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
