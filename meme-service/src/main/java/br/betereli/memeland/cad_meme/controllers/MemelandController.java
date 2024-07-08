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
@RequestMapping("/memeland")
public class MemelandController {

    public Logger LOGGER = LoggerFactory.getLogger(MemelandController.class);
    @Autowired
    private MemelandService memelandService;

    @GetMapping("/test")
    public String teste(){
        return "Chamada servico memelandia";
    }

    @GetMapping("/meme/{id}")
    public Meme findMemeById(@PathVariable Long id){
        LOGGER.info("Endpoint find meme by Id: " + id);
        return memelandService.findMemeById(id);
    }


    @GetMapping("/memes")
    public List<MemeDTO> findMemes() {
        LOGGER.info("Generated list with all memes registered. " + memelandService.listAllMemes().size() + " memes registered");
        return memelandService.listAllMemes();
    }

    @PostMapping("/memes")
    public MemeDTO newMeme(@RequestBody Meme meme) {
        LOGGER.info("new meme registered Id:" + meme.getId() + "Name: " + meme.getName());
        return memelandService.newMeme(meme);
    }
}
