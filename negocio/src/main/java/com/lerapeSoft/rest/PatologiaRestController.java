package com.lerapeSoft.rest;


import com.lerapeSoft.dto.Mensaje;
import com.lerapeSoft.entidades.Patologia;
import com.lerapeSoft.servicios.PatologiaServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Executable;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/patologia")
public class PatologiaRestController {


    @Autowired
    private PatologiaServicio patologiaServicio;


    @GetMapping("/listar")
    public ResponseEntity listar()
    {
        List<Patologia> listaPatologias = patologiaServicio.listarPatologias();

        return ResponseEntity.status(200).body(listaPatologias);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity obtenerPatologia(@PathVariable("id") String idPatologia)
    {
        try{
            Patologia patologia = patologiaServicio.obtenerPatologia(idPatologia)
                    ;
            return  ResponseEntity.status(200).body(patologia);
        }catch (Exception e)
        {
         return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Mensaje> crearPatologia(@RequestBody Patologia pato)
    {
        try{
            patologiaServicio.regirtrarPatologia(pato);
            return ResponseEntity.status(200).body(new Mensaje("La patologia se creo correctamente"));
        }catch (Exception e)
        {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizarPatologia(@RequestBody Patologia pato)
    {
        try{
            patologiaServicio.regirtrarPatologia(pato);
            return ResponseEntity.status(200).body(new Mensaje("La patologia se actualizo correctamente"));
        }catch (Exception e)
        {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("id") String id)
    {
        try{
            patologiaServicio.eliminarPatologia(id);
            return ResponseEntity.status(200).body(new Mensaje("La patologia se eliminó correctamente"));
        }catch (Exception e)
        {
            return  ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }
}
