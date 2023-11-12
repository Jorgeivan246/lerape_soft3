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




    @Query("SELECT re FROM Usuario u JOIN u.recetas re WHERE u.email = :email")
    Optional<Receta> obtenerRecetasFavoritasUsuario(String email);
/*

    @Query("SELECT FROM WHERE ")
    List<Receta> obtenerRecetasRecomendadas(String);







    @Query("SELECT r FROM Receta r JOIN r.patologias pt WHERE r.patologias IN (SELECT pt FROM Usuario u JOIN u.patologias pt WHERE u.email = :email ) ")
    List<Receta> obtenerRecetasRecomendadas(String email);


    @Query(nativeQuery = true, value = "     SELECT r  FROM receta as r INNER JOIN receta_patologias as rp ON r.id=rp.recetas_id  INNER JOIN patologia p ON rp.patologias_id=p.id WHERE p IN( SELECT p FROM Usuario as u INNER JOIN patologias_del_usuario as pu ON u.id=usuarios_id INNER JOIN patologia p ON pu.patologias_id=p.id WHERE u.email = :email)   ")
    List<Receta> obtenerRecetasRecomendadas(String idUsuario);

    */

}
