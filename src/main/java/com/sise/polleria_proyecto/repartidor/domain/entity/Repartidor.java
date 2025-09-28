package com.sise.polleria_proyecto.repartidor.domain.entity;



import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "repartidor")
public class Repartidor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_repartidor")
    private Integer idRepartidor;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "disponible", nullable = false)
    private String disponible;

    @Column(name = "fecha_creacion", updatable = false)
    private String fechaCreacion;

    @Column(name = "fecha_modificacion")
    private String fechaModificacion;

    
  
}
