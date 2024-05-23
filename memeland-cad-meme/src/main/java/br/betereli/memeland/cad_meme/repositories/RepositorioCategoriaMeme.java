package br.betereli.memeland.cad_meme.repositories;

import br.betereli.memeland.cad_meme.entities.CategoriaMeme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCategoriaMeme extends JpaRepository<CategoriaMeme, Long> {
}
