package br.betereli.memeland.cad_category.services;

import br.betereli.memeland.cad_category.entities.CategoriaMeme;
import br.betereli.memeland.cad_category.repositories.RepositorioCategoriaMeme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

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
}
