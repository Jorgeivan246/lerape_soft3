package com.lerapeSoft.entidades;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Patologia implements Serializable {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private String id;

    @Column(nullable=false)
    private String nombre;

    @Column(nullable=false)
    private StringBuilder descripcion;

    @ManyToMany(mappedBy = "patologias")
    private List<Receta> recetas;

    @ManyToMany
    @JoinTable(name="patologias_del_usuario")
    private List<Usuario> usuarios;

}
