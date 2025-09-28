package com.sise.polleria_proyecto.Usuario.Domain.Model;
 
import java.time.LocalDateTime;
 
import org.hibernate.annotations.CreationTimestamp; // Para autogenerar fecha de creación
import org.hibernate.annotations.UpdateTimestamp;   // Para autogenerar fecha de modificación
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@Entity
@Table(name = "usuario")
@NoArgsConstructor
public class Usuario {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
 
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
 
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
 
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
 
    @Column(name = "contrasena", nullable = false)
    private String contrasena;
 
    @Column(name = "telefono", length = 15)
    private String telefono;
 
    @Column(name = "direccion", length = 255)
    private String direccion;
 
    @Column(name = "rol", nullable = false, length = 50)
    private String rol;
 
    @Column(name = "estado", nullable = false, length = 10)
    private String estado;
 
    @CreationTimestamp
    @Column(name = "fecha_creacion", updatable = false)
    private LocalDateTime fechaCreacion;
 
 
    @UpdateTimestamp
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;
 
}