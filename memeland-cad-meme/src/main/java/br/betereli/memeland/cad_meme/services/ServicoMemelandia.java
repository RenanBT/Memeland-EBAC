package br.betereli.memeland.cad_meme.services;

import br.betereli.memeland.cad_meme.clients.CategoryClient;
import br.betereli.memeland.cad_meme.clients.UserClient;
import br.betereli.memeland.cad_meme.entities.CategoriaMeme;
import br.betereli.memeland.cad_meme.entities.Meme;
import br.betereli.memeland.cad_meme.entities.MemeDTO;
import br.betereli.memeland.cad_meme.entities.Usuario;
import br.betereli.memeland.cad_meme.repositories.RepositorioMeme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ServicoMemelandia {
    @Autowired
    private RepositorioMeme repositorioMeme;
    @Autowired
    private CategoryClient categoryClient;
    @Autowired
    private UserClient userClient;

    public MemeDTO novoMeme(Meme meme) {
        meme.setDataCadastro(new Date());
        Meme savedMeme = repositorioMeme.save(meme);
         return getMemeDTO(savedMeme);
    }

    public List<MemeDTO> listaTodosMemes() {
        List<Meme> listaMeme = repositorioMeme.findAll();
        List<MemeDTO> listaDTO = new ArrayList<>();
        listaMeme.forEach(meme -> {
            listaDTO.add(getMemeDTO(meme));
        });
        return listaDTO;
    }

    private MemeDTO getMemeDTO(Meme meme) {
        CategoriaMeme categoriaMeme = categoryClient.findCategoryById(meme.getCategoriaMemeId());
        Usuario usuario = userClient.findUserById(meme.getUsuarioId());
        return new MemeDTO(meme, categoriaMeme, usuario);
    }



}
