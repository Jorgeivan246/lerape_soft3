package com.lerapeSoft.test;

import com.lerapeSoft.entidades.Receta;
import com.lerapeSoft.entidades.Usuario;
import com.lerapeSoft.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    UsuarioRepo usuarioRepo;



    @Test
    public void registrarTest() {

        ArrayList<Receta> recetas = new ArrayList<>();


        ArrayList<String> patologia = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(123);
        usuario.setContraseña("adad");
        usuario.setRecetas(recetas);
        usuario.setCorreoElectronico("sfsfsf@gmail.com");
        usuario.setNombre("afafaf");
        usuario.setPatologias(patologia);


        usuarioRepo.save(usuario);
    }
}
