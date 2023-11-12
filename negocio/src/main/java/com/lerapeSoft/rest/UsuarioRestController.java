package com.lerapeSoft.rest;

import com.lerapeSoft.dto.Mensaje;
import com.lerapeSoft.entidades.Receta;
import com.lerapeSoft.entidades.Usuario;
import com.lerapeSoft.servicios.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/usuarios")
public class UsuarioRestController {


    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping
    public ResponseEntity listar() {
        List<Usuario> listaUsuarios = usuarioServicio.listarUsuario();
        return ResponseEntity.status(200).body(listaUsuarios);

    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity obtenerUsuario(@PathVariable("id") String email) {

        try {
            Usuario usuario = usuarioServicio.otenerUsuario(email);
            return ResponseEntity.status(200).body(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<Mensaje> crearUsuario(@RequestBody Usuario usuario) {

        try {
            usuarioServicio.registrarUsuario(usuario);
            return ResponseEntity.status(200).body(new Mensaje("El usuario se creo correctamente"));

        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }


    }


    @PostMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizarUsuario(@RequestBody Usuario usuario) throws Exception {

        try {
            usuarioServicio.actualizarUsuario(usuario);
            return ResponseEntity.status(200).body(new Mensaje("El usuario se actualizo correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("id") String email) {


        try {
            usuarioServicio.eliminarUsuario(email);
            return ResponseEntity.status(200).body(new Mensaje("El usuario se eliminó correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }

    }

/**
    @GetMapping("/recetas/recomendadas/{id}")
    public ResponseEntity listarRecetasRecomendadas(@PathVariable("id") String email)
    {

        List<Receta> listaRecetas = usuarioServicio.obtenerRecetasRecomendadas(email);

        return ResponseEntity.status(200).body(listaRecetas);
    }

**/
}
