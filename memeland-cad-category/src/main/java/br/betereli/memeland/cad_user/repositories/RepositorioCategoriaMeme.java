package br.betereli.memeland.cad_user.repositories;

import br.betereli.memeland.cad_user.entities.CategoriaMeme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioCategoriaMeme extends JpaRepository<CategoriaMeme, Long> {
}
