package br.betereli.memeland.cad_category.services;

import br.betereli.memeland.cad_category.entities.CategoriaMeme;
import br.betereli.memeland.cad_category.repositories.RepositorioCategoriaMeme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Component
public class ServicoMemelandia {

    @Autowired
    private RepositorioCategoriaMeme repositorioCategoriaMeme;

    public CategoriaMeme novaCategoriaMeme(CategoriaMeme categoriaMeme) {
        categoriaMeme.setDataCadastro(new Date());
        return repositorioCategoriaMeme.save(categoriaMeme);
    }
    public List<CategoriaMeme> listaTodasCategorias() {
        return repositorioCategoriaMeme.findAll();
    }

    public CategoriaMeme findCategoryById(Long id) {
        return repositorioCategoriaMeme.findById(id).orElse(null);
    }
}