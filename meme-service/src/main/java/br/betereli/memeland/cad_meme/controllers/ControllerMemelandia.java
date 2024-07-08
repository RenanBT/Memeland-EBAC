package br.betereli.memeland.cad_meme.controllers;



import br.betereli.memeland.cad_meme.entities.Meme;
import br.betereli.memeland.cad_meme.entities.MemeDTO;
import br.betereli.memeland.cad_meme.services.MemelandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memelandia")
public class ControllerMemelandia {

    public Logger LOGGER = LoggerFactory.getLogger(ControllerMemelandia.class);
    @Autowired
    private MemelandService memelandService;

    @GetMapping("/test")
    public String teste(){
        return "Chamada servico memelandia";
    }

    @GetMapping("/meme/{id}")
    public Meme findMemeById(@PathVariable Long id){
        LOGGER.info("Chamada meme por id: " + id);
        return memelandService.findMemeById(id);
    }


    @GetMapping("/memes")
    public List<MemeDTO> buscaMemes() {
        LOGGER.info("Gerada lista com " + memelandService.listaTodosMemes().size() + " memes cadastrados");
        return memelandService.listaTodosMemes();
    }

    @PostMapping("/memes")
    public MemeDTO novoMeme(@RequestBody Meme meme) {
        LOGGER.info("novo meme cadastrado Id:" + meme.getId() + "Nome: " + meme.getName());
        return memelandService.newMeme(meme);
    }
}
