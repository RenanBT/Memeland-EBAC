package br.betereli.memeland.cad_category.repositories;

import br.betereli.memeland.cad_category.entities.CategoriaMeme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCategoriaMeme extends JpaRepository<CategoriaMeme, Long> {
}
