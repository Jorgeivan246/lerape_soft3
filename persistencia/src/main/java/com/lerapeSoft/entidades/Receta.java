package com.lerapeSoft.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Receta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;


    private String nombre;


    private String ingrediente;

    private StringBuilder descripcion;

    private StringBuilder preparacion;

    private String tiempoPreparacion;

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
