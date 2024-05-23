package br.betereli.memeland.cad_user.services;

import br.betereli.memeland.cad_user.entities.CategoriaMeme;
import br.betereli.memeland.cad_user.entities.Meme;
import br.betereli.memeland.cad_user.entities.Usuario;
import br.betereli.memeland.cad_user.repositories.RepositorioMeme;
import br.betereli.memeland.cad_user.repositories.RepositorioUsuario;
import br.betereli.memeland.cad_user.repositories.RepositorioCategoriaMeme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicoMemelandia {
    @Autowired
    private RepositorioMeme repositorioMeme;

    @Autowired
    private RepositorioCategoriaMeme repositorioCategoriaMeme;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Usuario novoUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public List<Usuario> listaTodosUsuarios() {
        return repositorioUsuario.findAll();
    }

    public Meme novoMeme(Meme meme) {
        return repositorioMeme.save(meme);
    }

    public List<Meme> listaTodosMemes() {
        return repositorioMeme.findAll();
    }

    public CategoriaMeme novaCategoriaMeme(CategoriaMeme categoriaMeme) {
        return repositorioCategoriaMeme.save(categoriaMeme);
    }

    public List<CategoriaMeme> listaTodasCategorias() {
        return repositorioCategoriaMeme.findAll();
    }
}