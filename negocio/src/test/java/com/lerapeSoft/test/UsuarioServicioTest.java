package com.lerapeSoft.test;


import com.lerapeSoft.NegocioApplication;
import com.lerapeSoft.entidades.Usuario;
import com.lerapeSoft.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = NegocioApplication.class)
@Transactional
public class UsuarioServicioTest {


    @Autowired
    private UsuarioServicio usuarioServicio;


    @Test
    public void registrarUsuario() {
        Usuario u = new Usuario();

        u.setNombre("Condoriano");
        u.setId("123");
        u.setPassword("micontraseña");
        u.setEmail("jorge@gmail.com");
        try {
            Usuario respuesta = usuarioServicio.registrarUsuario(u);

            Assertions.assertNotNull(respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void eliminarTest()
    {
        try {
            usuarioServicio.eliminarUsuario("123");
            Assertions.assertTrue(false);
        } catch (Exception e) {

            throw new RuntimeException(e);
        }


    }


}
