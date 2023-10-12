package com.lerapeSoft.test;

import com.lerapeSoft.entidades.Receta;
import com.lerapeSoft.entidades.Usuario;
import com.lerapeSoft.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UsuarioTest {

    @Autowired
    UsuarioRepo usuarioRepo;

    @Test
    public void loginTest()
    {
        ArrayList<Receta> recetas = new ArrayList<>();


        ArrayList<String> patologia = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(123);
        usuario.setPassword("adad");
        usuario.setRecetas(recetas);
        usuario.setEmail("sfsfsf@gmail.com");
        usuario.setNombre("afafaf");
        usuario.setPatologias(patologia);


        Usuario usuarioGuardado=        usuarioRepo.save(usuario);

        Usuario usuarioBus=usuarioRepo.findByEmailAndPassword(usuarioGuardado.getEmail(),usuarioGuardado.getPassword());


        Assertions.assertEquals(usuarioBus.getNombre(),usuario.getNombre());
    }


    @Test
    public void registrarTest() {

        ArrayList<Receta> recetas = new ArrayList<>();


        ArrayList<String> patologia = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(123);
        usuario.setEmail("adad");
        usuario.setRecetas(recetas);
        usuario.setEmail("sfsfsf@gmail.com");
        usuario.setNombre("afafaf");
        usuario.setPatologias(patologia);


Usuario usuarioGuardado=        usuarioRepo.save(usuario);

        Assertions.assertNotNull(usuarioGuardado);
    }


    @Test
    public void eliminarTest(){
        ArrayList<Receta> recetas = new ArrayList<>();


        ArrayList<String> patologia = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(123);
        usuario.setPassword("adad");
        usuario.setRecetas(recetas);
        usuario.setEmail("sfsfsf@gmail.com");
        usuario.setNombre("afafaf");
        usuario.setPatologias(patologia);


        Usuario usuarioBuscado=        usuarioRepo.save(usuario);


        usuarioRepo.deleteById(123);

        usuarioBuscado=usuarioRepo.findById(123).orElse(null);
        Assertions.assertNull(usuarioBuscado );



    }



    @Test

    public void actualizarTest()
    {
        ArrayList<Receta> recetas = new ArrayList<>();


        ArrayList<String> patologia = new ArrayList<>();

        Usuario usuario = new Usuario();
        usuario.setId(123);
        usuario.setPassword("adad");
        usuario.setRecetas(recetas);
        usuario.setEmail("micorreo@gmail.com");
        usuario.setNombre("afafaf");
        usuario.setPatologias(patologia);




        Usuario usuarioGuardado=        usuarioRepo.save(usuario);

        usuarioGuardado.setEmail("correo@gmail.com");



       Usuario user= usuarioRepo.save(usuarioGuardado);


        System.out.println(""+user.getEmail());


       Usuario usuarioBus=usuarioRepo.findById(123).orElse(null);



       Assertions.assertEquals("correo@gmail.com",usuarioBus.getEmail());



    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Usuario> usuarios = usuarioRepo.findAll();

        System.out.println(usuarios);
    }
}
