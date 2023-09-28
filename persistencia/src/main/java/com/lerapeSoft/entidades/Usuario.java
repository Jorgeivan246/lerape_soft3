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
public class Usuario<mappedBy> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable=false)
    private String nombre;

    @Column(nullable=false)
    private String contraseña;

    @EqualsAndHashCode.Include
    @Column(unique=true,nullable=false)
    private String correoElectronico;

    @ElementCollection
    @Column(nullable=false)
    @JoinColumn(nullable = false)
    private List<String> patologias;

    @OneToMany(mappedBy = "usuario")
    private List<Receta> recetas;

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
