package com.lerapeSoft.rest;

import com.lerapeSoft.dto.Mensaje;
import com.lerapeSoft.entidades.Receta;
import com.lerapeSoft.servicios.RecetaServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/recetas")
public class RecetaRestController {

    @Autowired
    private RecetaServicio recetaServicio;

    @GetMapping("/listar")
    public ResponseEntity listar() {
        List<Receta> listaRecetas = recetaServicio.listarRecetas();
        return ResponseEntity.status(200).body(listaRecetas);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity obtenerReceta(@PathVariable("id") String idReceta) {
        try {
            Receta receta = recetaServicio.obtenerReceta(idReceta);

            return ResponseEntity.status(200).body(receta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }

    }


    @PostMapping("/crear")
    public ResponseEntity<Mensaje> crearReceta(@RequestBody Receta receta) {
        try {
            recetaServicio.registrarReceta(receta);
            return ResponseEntity.status(200).body(new Mensaje("La receta  se creo correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizarReceta(@RequestBody Receta receta) {
        try {
            recetaServicio.actualizarReceta(receta);
            return ResponseEntity.status(200).body(new Mensaje("La receta se ha actualizado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("id") String id) {
        try {
            recetaServicio.eliminarReceta(id);
            return ResponseEntity.status(200).body(new Mensaje("La receta se elimino correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }


}
