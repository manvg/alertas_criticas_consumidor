package com.alertas_medicas.alertas_criticas_consumidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alertas_medicas.alertas_criticas_consumidor.model.AlertaMedica;

@Repository
public interface AlertaMedicaRepository extends JpaRepository<AlertaMedica, Integer> {
    
}
