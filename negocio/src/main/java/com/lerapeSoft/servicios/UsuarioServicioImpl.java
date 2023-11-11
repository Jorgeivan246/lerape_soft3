package com.lerapeSoft.servicios;

import com.lerapeSoft.entidades.Usuario;
import com.lerapeSoft.repositorios.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {


    private final UsuarioRepo usuarioRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public boolean estaDisponible(String email) {
        Optional<Usuario> usuario = usuarioRepo.findByEmail(email);
        return usuario.isEmpty();
    }

    @Override
    public Usuario registrarUsuario(Usuario u) throws Exception {
        Optional<Usuario> buscado = usuarioRepo.findByEmail(u.getEmail());

        if (!estaDisponible(u.getEmail())) {
            throw new Exception("El email ya se encuentra en uso");
        }
        return usuarioRepo.save(u);
    }

    @Override
    public Usuario otenerUsuario(String email) throws Exception {

        Optional<Usuario> usuario = usuarioRepo.findByEmail(email);
        if (usuario.isEmpty()) {
            throw new Exception("No existe un usuario con el email dado");
        }
        return usuario.get();

    }

    @Override
    public Usuario actualizarUsuario(Usuario u) throws Exception {
        return usuarioRepo.save(u);
    }

    @Override
    public Usuario login(String email, String password) throws Exception {
        Optional<Usuario> usuario = Optional.ofNullable(usuarioRepo.findByEmailAndPassword(email, password));

        if (usuario.isEmpty()) {
            throw new Exception("El usuario no existe");
        }

        return usuario.get();

    }

    @Override
    public void eliminarUsuario(String email) throws Exception {
        Optional<Usuario> usuario = usuarioRepo.findById(email);
        if (usuario.isEmpty()) {
            throw new Exception("No existe un usuario con el email dado");
        } else {
            usuarioRepo.deleteById(email);
        }


    }


    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepo.findAll();
    }
}
