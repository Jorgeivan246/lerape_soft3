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



        Optional<Receta> findByNombre(String nombre);
}
