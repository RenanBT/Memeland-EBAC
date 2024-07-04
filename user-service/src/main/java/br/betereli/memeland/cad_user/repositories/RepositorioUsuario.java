package br.betereli.memeland.cad_user.repositories;

import br.betereli.memeland.cad_user.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}
