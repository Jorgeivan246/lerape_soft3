package com.lerapeSoft.repositorios;

import com.lerapeSoft.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,String> {

    List<Usuario> findAllByNombre(String nombre);

    Optional<Usuario> findByEmail(String email);


    Usuario findByEmailAndPassword(String correo, String password);
}
