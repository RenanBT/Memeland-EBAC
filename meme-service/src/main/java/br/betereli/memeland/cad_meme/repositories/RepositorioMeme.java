package br.betereli.memeland.cad_meme.repositories;

import br.betereli.memeland.cad_meme.entities.Meme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioMeme extends JpaRepository<Meme, Long> {
}
