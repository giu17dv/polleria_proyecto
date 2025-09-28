package com.sise.polleria_proyecto.comprobantepago.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Entity
@Table(name = "comprobante_pago")
@NoArgsConstructor
public class ComprobantePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comprobante_pago")
    private Integer idComprobantePago;

    
    @JoinColumn(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    
    @JoinColumn(name = "id_pedido", nullable = false)
    private Integer idPedido;

    @Column(name = "tipo", nullable = false, length = 20)
    private String tipo; // Boleta, Factura, Ticket, etc.

    @Column(name = "monto_total", nullable = false, precision = 10, scale = 2)
    private BigDecimal montoTotal;

    @Column(name = "fecha_emision", nullable = false)
    private LocalDateTime fechaEmision;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_modificacion", insertable = false, updatable = false)
    private LocalDateTime fechaModificacion;
}
