package com.sise.polleria_proyecto.pedido.domain.entities;

import jakarta.persistence.Id;
import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDateTime;




@Data
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    
    private Integer idPedido;

    
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;


    @Column(name = "fecha_hora_pedido")
    private LocalDateTime fechaHoraPedido;

    
    @Column(name = "estado")
    private String estado;

    @Column(name = "total")
    private Double total;

    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    
}

