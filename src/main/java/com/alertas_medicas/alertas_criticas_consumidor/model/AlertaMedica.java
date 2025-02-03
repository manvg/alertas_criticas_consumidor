package com.alertas_medicas.alertas_criticas_consumidor.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alerta_medica")
public class AlertaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alerta_medica")
    private int idAlertaMedica;

   @Column(name = "nombre_paciente", nullable = false, length = 100)
    private String nombrePaciente;

    @Column(name = "ritmo_cardiaco", nullable = false)
    private int ritmoCardiaco;

    @Column(name = "temperatura", nullable = false, precision = 5)
    private double temperatura;

    @Column(name = "presion_sistolica", nullable = false)
    private int presionSistolica;

    @Column(name = "presion_diastolica", nullable = false)
    private int presionDiastolica;

    @Column(name = "observacion", length = 255)
    private String observacion;

    @Column(name = "fecha_registro", nullable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    public AlertaMedica() {
        this.fechaRegistro = LocalDateTime.now();
    }

    public Integer getId() {
        return idAlertaMedica;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getRitmoCardiaco() {
        return ritmoCardiaco;
    }

    public void setRitmoCardiaco(int ritmoCardiaco) {
        this.ritmoCardiaco = ritmoCardiaco;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getPresionSistolica() {
        return presionSistolica;
    }

    public void setPresionSistolica(int presionSistolica) {
        this.presionSistolica = presionSistolica;
    }

    public int getPresionDiastolica() {
        return presionDiastolica;
    }

    public void setPresionDiastolica(int presionDiastolica) {
        this.presionDiastolica = presionDiastolica;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }
}
