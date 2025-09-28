package com.sise.polleria_proyecto.inventario.domain.entity;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "inventario")
@NoArgsConstructor
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Integer idInventario;

    @Column(name = "id_producto", nullable = false)
    private Integer idProducto; // Relación con Producto (puedes mapear luego con @ManyToOne si quieres)

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "stock_minimo", nullable = false)
    private Integer stockMinimo;

    @Column(name = "ubicacion", length = 100)
    private String ubicacion;

    @Column(name = "fecha_creacion", insertable = false, updatable = false)
    private String fechaCreacion;

    @Column(name = "fecha_modificacion", insertable = false, updatable = false)
    private String fechaModificacion;
}
