package br.betereli.memeland.cad_meme.services;

import br.betereli.memeland.cad_meme.clients.CategoryClient;
import br.betereli.memeland.cad_meme.clients.UserClient;
import br.betereli.memeland.cad_meme.entities.memeCategory;
import br.betereli.memeland.cad_meme.entities.Meme;
import br.betereli.memeland.cad_meme.entities.MemeDTO;
import br.betereli.memeland.cad_meme.entities.User;
import br.betereli.memeland.cad_meme.repositories.MemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MemelandService {
    @Autowired
    private MemeRepository repositorioMeme;
    @Autowired
    private CategoryClient categoryClient;
    @Autowired
    private UserClient userClient;

    public MemeDTO newMeme(Meme meme) {
        meme.setRegistryDate(new Date());
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
        memeCategory memeCategory = categoryClient.findCategoryById(meme.getMemeCategoryId());
        User user = userClient.findUserById(meme.getUserId());
        return new MemeDTO(meme, memeCategory, user);
    }


    public Meme findMemeById(Long id) {
        return repositorioMeme.findById(id).orElse(null);
    }
}
