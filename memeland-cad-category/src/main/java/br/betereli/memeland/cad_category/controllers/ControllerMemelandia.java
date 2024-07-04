package br.betereli.memeland.cad_category.controllers;

import br.betereli.memeland.cad_category.entities.CategoriaMeme;
import br.betereli.memeland.cad_category.services.ServicoMemelandia;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memelandia")
public class ControllerMemelandia {

    public Logger LOGGER = LoggerFactory.getLogger(ControllerMemelandia.class);

    @GetMapping("/cadcategory")
    public String teste(){

        return "Chamada Cad Category";
    }

    @Autowired
    private ServicoMemelandia servicoMemelandia;
    @GetMapping("/categorias")
    public List<CategoriaMeme> buscaCategorias() {
        LOGGER.info("Gerada lista com todas as categorias");
        return servicoMemelandia.listaTodasCategorias();
    }

    @GetMapping("/categorias/{id}")
    public CategoriaMeme findCategoryById(@PathVariable Long id){
        LOGGER.info("Encontrar Categoria por Id: " + id);
        return servicoMemelandia.findCategoryById(id);
    }

    @PostMapping("/categorias")
    public CategoriaMeme novaCategoria(@RequestBody CategoriaMeme categoriaMeme) {
        LOGGER.info("Criada nova categoria Id: " + categoriaMeme.getId() + " nome: " + categoriaMeme.getNome());
        return servicoMemelandia.novaCategoriaMeme(categoriaMeme);
    }

}
