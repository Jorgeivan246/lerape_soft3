package com.lerapeSoft.servicios;

import com.lerapeSoft.entidades.Receta;
import com.lerapeSoft.repositorios.RecetaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RecetaServicioImpl implements RecetaServicio {

    private final RecetaRepo recetaRepo;

    public RecetaServicioImpl(RecetaRepo recetaRepo) {
        this.recetaRepo = recetaRepo;
    }

    @Override
    public Receta registrarReceta(Receta re) throws Exception {


        return recetaRepo.save(re);
    }

    @Override
    public Receta actualizarReceta(Receta re) throws Exception {
        return recetaRepo.save(re);
    }


    @Override
    public void eliminarReceta(String id) throws Exception {
        Optional<Receta> recetaEncontrada = recetaRepo.findById(id);

        if (recetaEncontrada.isEmpty()) {
            throw new Exception("La receta no se encuentra registrada");
        } else {
            recetaRepo.deleteById(recetaEncontrada.get().getId());
        }
    }

    @Override
    public List<Receta> listarRecetas() {

        List<Receta> recetas = recetaRepo.findAll();


        return recetas;
    }

    @Override
    public Receta obtenerReceta(String id) throws Exception {

        Optional<Receta> receta = recetaRepo.findById(id);


        if (receta.isEmpty()) {
            throw new Exception("La receta no se encuentra registrada");
        }

        return receta.get();
    }

    @Override
    public Receta registrarRecetaFavoritaUsuario(Receta re)
    {
        return recetaRepo.save(re);



    }

    @Override
    public List<Receta> listarRecetasFavoritas(String email) throws Exception
    {
        Optional<Receta> recetasFav=recetaRepo.obteneRecetasFavoritasUsuario(email);

        if(recetasFav.isEmpty())
        {
            throw new Exception("No tiene recetas favoritas agregadas");
        }

        return (List<Receta>) recetasFav.get();
    }

    @Override
    public void eliminarRecetasFavoritasUsuario(String email) throws Exception {
        Optional<Receta> recetasFav=recetaRepo.obteneRecetasFavoritasUsuario(email);

        if(recetasFav.isEmpty())
        {
            throw new Exception("No tiene recetas favoritas agregadas");
        }else{
            recetaRepo.eliminarRecetasFavoritasUsuario(email);
        }

    }

    @Override
    public Receta actualizarRecetaFavorita(Receta receta) throws Exception {


        return  recetaRepo.save(receta);
    }


}
