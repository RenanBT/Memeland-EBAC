package br.betereli.memeland.cad_user.services;

import br.betereli.memeland.cad_user.entities.Usuario;
import br.betereli.memeland.cad_user.repositories.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class UserService {


    @Autowired
    private RepositorioUsuario repositorioUsuario;


    public Usuario novoUsuario(Usuario usuario) {
        usuario.setDataCadastro(new Date());
        return repositorioUsuario.save(usuario);
    }

    public List<Usuario> listaTodosUsuarios() {
        return repositorioUsuario.findAll();
    }


    public Usuario findUserById(Long id) {
        return repositorioUsuario.findById(id).orElse(null);
    }
}
