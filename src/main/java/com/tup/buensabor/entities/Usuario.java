package com.tup.buensabor.entities;

import jakarta.persistence.*;

import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Collection;
import java.util.Date;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuario")
public class Usuario extends Base {

    @NotNull
    @Column(name = "auth0_id", nullable = false, unique = true)
    private String auth0Id;

    @NotNull
    @Column(name = "username", nullable = false)
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

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


<<<<<<< HEAD

}
=======
}
>>>>>>> TestAnfran
