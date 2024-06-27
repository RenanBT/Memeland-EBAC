package br.betereli.memeland.cad_meme.clients;

import br.betereli.memeland.cad_meme.entities.CategoriaMeme;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "caregoria-service", url = "http://localhost:8082")
public interface CategoryClient {

    @GetMapping("/memelandia/categorias/{id}")
    CategoriaMeme findCategoryById(@PathVariable("id") Long id);
}

//http://localhost:8082/memelandia/categorias/2/memelandia/categorias/2
