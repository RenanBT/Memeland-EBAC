package br.betereli.memeland.cad_meme.repositories;

import br.betereli.memeland.cad_meme.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}
