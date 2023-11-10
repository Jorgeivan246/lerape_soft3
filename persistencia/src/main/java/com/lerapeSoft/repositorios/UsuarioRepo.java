package com.lerapeSoft.repositorios;

import com.lerapeSoft.entidades.Receta;
import com.lerapeSoft.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,String> {

    List<Usuario> findAllByNombre(String nombre);

    Optional<Usuario> findByEmail(String email);


    Usuario findByEmailAndPassword(String correo, String password);


    @Query(nativeQuery = true, value = "select * from receta r")
    List<Receta> obtenerRecetasRecomendadas11(String idUsuario);


    @Query("SELECT re FROM Receta re JOIN re.usuarios u WHERE u.id = :idUsuario and u.patologias IN ( SELECT pt from Receta r join r.patologias pt ) ")
    List<Receta> obtenerRecetasRecomendadas(String idUsuario);

}
