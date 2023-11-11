package com.lerapeSoft.repositorios;

import com.lerapeSoft.entidades.Patologia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatologiaRepo extends JpaRepository<Patologia,String> {



}
