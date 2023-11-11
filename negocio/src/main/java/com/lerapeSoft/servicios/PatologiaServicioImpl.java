package com.lerapeSoft.servicios;

import com.lerapeSoft.entidades.Patologia;
import com.lerapeSoft.entidades.Receta;
import com.lerapeSoft.repositorios.PatologiaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatologiaServicioImpl implements PatologiaServicio {


    private final PatologiaRepo patologiaRepo;

    public PatologiaServicioImpl(PatologiaRepo patologiaRepo) {
        this.patologiaRepo = patologiaRepo;
    }


    @Override
    public Patologia regirtrarPatologia(Patologia pa) throws Exception {


        return patologiaRepo.save(pa);
    }

    @Override
    public Patologia actualizarPatologia(Patologia pa) throws Exception {


        return patologiaRepo.save(pa);
    }

    @Override
    public void eliminarPatologia(String id) throws Exception {

        Optional<Patologia> patologiaEncontrada = patologiaRepo.findById(id);

        if(patologiaEncontrada.isEmpty())
        {
            throw new Exception("La patologia no se encuentra registrada");
        }else{
            patologiaRepo.deleteById(patologiaEncontrada.get().getId());
        }
    }

    @Override
    public List<Patologia> listarPatologias() {

        List<Patologia> patologias = patologiaRepo.findAll();


        return patologias;
    }

    @Override
    public Patologia obtenerPatologia(String id) throws Exception {

        Optional<Patologia> patologia = patologiaRepo.findById(id);

        if(patologia.isEmpty())
        {
            throw new Exception("La patologia no se encuentra registrada");
        }

        return patologia.get();




    }
}
