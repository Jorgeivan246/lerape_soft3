package com.lerapeSoft.repositorios;

import com.lerapeSoft.entidades.Receta;
import com.lerapeSoft.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecetaRepo extends JpaRepository <Receta,String> {

        @Query("SELECT re FROM Receta re WHERE re.nombre like concat('%',:nombre,'%')")
        Optional<Receta> obtenerRecetaPorNombre(String nombre);

        @Query(nativeQuery = true,value = "DELETE FROM Receta r INNER JOIN  recetas_favoritas rf ON r.id=rf.recetas_id INNER JOIN Usuario u ON rf.usuarios_id=u.id WHERE u.email = :email)")
        Optional<Receta> eliminarRecetasFavoritasUsuario(String email);

        @Query("SELECT re FROM Receta re JOIN re.usuarios u WHERE u.email = :email")
        Optional<Receta> obteneRecetasFavoritasUsuario(String email);

        Optional<Receta> findByNombre(String nombre);
}
