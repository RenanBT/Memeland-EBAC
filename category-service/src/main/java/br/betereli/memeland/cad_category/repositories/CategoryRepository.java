package br.betereli.memeland.cad_category.repositories;

import br.betereli.memeland.cad_category.entities.MemeCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<MemeCategory, Long> {
}
