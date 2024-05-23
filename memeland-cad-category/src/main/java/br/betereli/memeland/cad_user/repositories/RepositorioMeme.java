package br.betereli.memeland.cad_user.repositories;

import br.betereli.memeland.cad_user.entities.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMeme extends JpaRepository<Meme, Long> {
}
