package com.tup.buensabor.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Data
@Table(name = "Rol")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Rol extends Base {
    @NotNull
    private String nombreRol;
    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_Rol")
    @Builder.Default
    private List<Usuario> usuarios = new ArrayList<>();

    public void agregarusuario(Usuario usuario) {
        usuarios.add(usuario);

    }
}