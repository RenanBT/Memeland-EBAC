package br.betereli.memeland.cad_meme.controllers;



import br.betereli.memeland.cad_meme.entities.Meme;
import br.betereli.memeland.cad_meme.entities.MemeDTO;
import br.betereli.memeland.cad_meme.services.ServicoMemelandia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memelandia")
public class ControllerMemelandia {
    @Autowired
    private ServicoMemelandia servicoMemelandia;

    @GetMapping("/test")
    public String teste(){
        return "Chamada servico memelandia";
    }

    @GetMapping("/memes")
    public List<MemeDTO> buscaMemes() {
        return servicoMemelandia.listaTodosMemes();
    }

    @PostMapping("/memes")
    public MemeDTO novoMeme(@RequestBody Meme meme) {
        return servicoMemelandia.novoMeme(meme);
    }
}
