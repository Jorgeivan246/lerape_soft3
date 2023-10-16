package com.lerapeSoft.repositorios;

import com.lerapeSoft.entidades.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepo extends JpaRepository <Receta,Long> {
}
