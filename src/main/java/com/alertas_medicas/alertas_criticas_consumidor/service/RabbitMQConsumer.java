package com.alertas_medicas.alertas_criticas_consumidor.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.alertas_medicas.alertas_criticas_consumidor.model.SignosVitales;

@Service
public class RabbitMQConsumer {

    private final AlertaMedicaService alertaMedicaService;

    public RabbitMQConsumer(AlertaMedicaService alertaMedicaService) {
        this.alertaMedicaService = alertaMedicaService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.alertas_criticas}")
    public void recibirAlerta(SignosVitales signos) {
        System.out.println("RabbitMQ =>Alerta crítica recibida para el paciente: " + signos.getNombrePaciente());
        alertaMedicaService.guardarAlerta(signos);
        System.out.println("RabbitMQ => Alerta guardada en la base de datos.");
    }
}
