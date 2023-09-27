package com.lerapeSoft.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String nombre;

    private String contraseña;

    @EqualsAndHashCode.Include
    private String correoElectronico;

    @ElementCollection
    private List<String> patologias;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        if (!id.equals(usuario.id)) return false;
        return correoElectronico.equals(usuario.correoElectronico);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + correoElectronico.hashCode();
        return result;
    }


}
