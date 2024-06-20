package br.betereli.memeland.cad_meme.services;

import br.betereli.memeland.cad_meme.entities.CategoriaMeme;
import br.betereli.memeland.cad_meme.entities.Meme;
import br.betereli.memeland.cad_meme.repositories.RepositorioMeme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicoMemelandia {
    @Autowired
    private RepositorioMeme repositorioMeme;

    @Autowired
    public Meme novoMeme(Meme meme) {
        return repositorioMeme.save(meme);
    }

    public List<Meme> listaTodosMemes() {
        return repositorioMeme.findAll();
    }

}
