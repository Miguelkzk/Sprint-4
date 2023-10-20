package com.tup.buensabor.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@Table(name = "localidad")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Localidad extends Base{
    @NotNull
    private String nombre;

    @NotNull
    @Column(precision = 4)
    private Integer codigoPostal;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_localidad")
    @Builder.Default
    private List<Domicilio> domicilios=new ArrayList<>();
    public void agregardomicilio(Domicilio domicilio){
        domicilios.add(domicilio);
    }
}
