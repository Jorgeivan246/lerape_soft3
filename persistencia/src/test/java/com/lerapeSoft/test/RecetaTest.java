package com.lerapeSoft.test;

import com.lerapeSoft.entidades.Dificultad;
import com.lerapeSoft.entidades.Receta;
import com.lerapeSoft.repositorios.RecetaRepo;
import com.lerapeSoft.repositorios.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RecetaTest {


    @Autowired
    RecetaRepo recetaRepo;


    @Test
    public void registrarReceta() {
        Receta miReceta = new Receta();

        miReceta.setNombre("Panckaes de avena");

        miReceta.setId(123);

        miReceta.setPreparacion(new StringBuilder("Ponga avena en horjuelas a herir con agua 5 minutos , luego agrege banano y canela"));

        miReceta.setTiempoPreparacion(5);

        Receta recetaGuardada = recetaRepo.save(miReceta);

        Assertions.assertNotNull(recetaGuardada);

    }

    @Test
    public void eliminarReceta() {
        Receta miReceta = new Receta();

        miReceta.setNombre("Panckaes de avena");

        miReceta.setId(123);

        miReceta.setPreparacion(new StringBuilder("Ponga avena en horjuelas a herir con agua 5 minutos , luego agrege banano y canela"));

        miReceta.setTiempoPreparacion(5);

        recetaRepo.save(miReceta);

        recetaRepo.deleteById(123);


        Receta recetaBuscada = recetaRepo.findById(123).orElse(null);

        Assertions.assertNull(recetaBuscada);


    }


    @Test
    public void editarReceta() {
        Receta miReceta = new Receta();

        miReceta.setNombre("Panckaes de avena");

        miReceta.setId(123);

        miReceta.setDificultad(Dificultad.valueOf("FACIL"));

        miReceta.setPreparacion(new StringBuilder("Ponga avena en horjuelas a herir con agua 5 minutos , luego agrege banano y canela"));

        miReceta.setTiempoPreparacion(5);

        Receta recetaGuardada = recetaRepo.save(miReceta);

        recetaGuardada.setDificultad(Dificultad.valueOf("DIFICIL"));

        recetaRepo.save(recetaGuardada);

        Receta recetaBuscada = recetaRepo.findById(123).orElse(null);

        Assertions.assertEquals(recetaBuscada.getDificultad().name(), "DIFICIL");
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarRecetas()
    {
       List<Receta> recetas= recetaRepo.findAll();

        System.out.println(""+recetas);
    }
}
