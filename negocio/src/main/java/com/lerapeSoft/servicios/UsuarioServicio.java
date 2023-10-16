package com.lerapeSoft.servicios;

import com.lerapeSoft.entidades.Usuario;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws  Exception;

    Usuario actualizarUsuario(Usuario u) throws  Exception;

    Usuario login(String email , String password) throws Exception;

    void eliminarUsuario(String id) throws  Exception;


    List<Usuario> listarUsuario();

    Usuario otenerUsuario(String id) throws Exception;
}
