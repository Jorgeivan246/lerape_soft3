package com.lerapeSoft.servicios;

import com.lerapeSoft.entidades.Receta;

import java.lang.reflect.Executable;
import java.util.List;

public interface RecetaServicio {


    Receta registrarReceta(Receta re) throws Exception;

    Receta actualizarReceta(Receta re) throws Exception;


    void eliminarReceta(String id) throws Exception;


    List<Receta> listarRecetas();

    Receta obtenerReceta(String id) throws Exception;

    Receta registrarRecetaFavoritaUsuario(Receta re) throws Exception;

    List<Receta> listarRecetasFavoritas(String id) throws  Exception;

    void eliminarRecetasFavoritasUsuario(String email) throws Exception;

    Receta actualizarRecetaFavorita(Receta receta) throws  Exception;



}