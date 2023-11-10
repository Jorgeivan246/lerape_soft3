package com.lerapeSoft.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
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

public class Receta implements Serializable {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private String id;

    @Column(nullable=false)
    private String nombre;

    @Column(nullable=false)
    private String ingrediente;

    @Column(nullable=false)
    private StringBuilder descripcion;

    @Column(nullable=false)
    private StringBuilder preparacion;

    @ElementCollection
    private List<String> patologias;

    @Column(nullable=false)
    @Positive
    private Integer tiempoPreparacion;


    @ManyToMany
    //@JoinColumn(nullable = false)
    List<Usuario> usuarios;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private  Dificultad dificultad;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Receta receta = (Receta) o;

        return id.equals(receta.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
