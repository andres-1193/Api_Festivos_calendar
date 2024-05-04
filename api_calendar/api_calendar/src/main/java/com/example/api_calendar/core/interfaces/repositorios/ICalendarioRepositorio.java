package com.example.api_calendar.core.interfaces.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api_calendar.core.entidades.Calendario;
@Repository
public interface ICalendarioRepositorio  extends JpaRepository<Calendario, Long>{

}
