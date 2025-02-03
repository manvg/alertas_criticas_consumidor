package com.alertas_medicas.alertas_criticas_consumidor.service;

import org.springframework.stereotype.Service;

import com.alertas_medicas.alertas_criticas_consumidor.model.AlertaMedica;
import com.alertas_medicas.alertas_criticas_consumidor.model.SignosVitales;
import com.alertas_medicas.alertas_criticas_consumidor.repository.AlertaMedicaRepository;

@Service
public class AlertaMedicaService {

    private final AlertaMedicaRepository alertaMedicaRepository;

    public AlertaMedicaService(AlertaMedicaRepository alertaMedicaRepository) {
        this.alertaMedicaRepository = alertaMedicaRepository;
    }

    public void guardarAlerta(SignosVitales signos) {
        AlertaMedica alerta = new AlertaMedica();
        alerta.setNombrePaciente(signos.getNombrePaciente());
        alerta.setRitmoCardiaco(signos.getRitmoCardiaco());
        alerta.setTemperatura(signos.getTemperatura());
        alerta.setPresionSistolica(signos.getPresionSistolica());
        alerta.setPresionDiastolica(signos.getPresionDiastolica());

        //Determinar signos vitales alterados
        String observacion = generarObservacion(signos);
        alerta.setObservacion(observacion);

        alertaMedicaRepository.save(alerta);
        System.out.println("Alerta guardada en la base de datos para el paciente: " + signos.getNombrePaciente());
    }

    private String generarObservacion(SignosVitales signos) {
        StringBuilder observacion = new StringBuilder("Signos vitales alterados: ");

        boolean alterado = false;

        if (signos.getRitmoCardiaco() < 50 || signos.getRitmoCardiaco() > 120) {
            observacion.append("Ritmo Cardíaco: ").append(signos.getRitmoCardiaco()).append(" bpm. ");
            alterado = true;
        }
        if (signos.getTemperatura() < 35.0 || signos.getTemperatura() > 38.0) {
            observacion.append("Temperatura: ").append(signos.getTemperatura()).append("°C. ");
            alterado = true;
        }
        if (signos.getPresionSistolica() < 90 || signos.getPresionSistolica() > 140) {
            observacion.append("Presión Sistólica: ").append(signos.getPresionSistolica()).append(" mmHg. ");
            alterado = true;
        }
        if (signos.getPresionDiastolica() < 60 || signos.getPresionDiastolica() > 90) {
            observacion.append("Presión Diastólica: ").append(signos.getPresionDiastolica()).append(" mmHg. ");
            alterado = true;
        }

        return alterado ? observacion.toString().trim() : "ℹ️ Todos los valores dentro del rango crítico.";
    }
}