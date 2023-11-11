package com.lerapeSoft.servicios;

import com.lerapeSoft.entidades.Patologia;

import java.util.List;

public interface PatologiaServicio {


    Patologia regirtrarPatologia(Patologia pa) throws Exception;

    Patologia actualizarPatologia(Patologia pa) throws Exception;

    void eliminarPatologia(String id) throws Exception;

    List<Patologia> listarPatologias();

    Patologia obtenerPatologia(String id) throws Exception;


}
