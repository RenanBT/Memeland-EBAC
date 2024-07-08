package br.betereli.memeland.cad_category.services;

import br.betereli.memeland.cad_category.entities.MemeCategory;
import br.betereli.memeland.cad_category.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public MemeCategory newCategory(MemeCategory memeCategory) {
        if (memeCategory.getDescription() == null || memeCategory.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        memeCategory.setRegistryDate(new Date());
        return categoryRepository.save(memeCategory);
    }

    public List<MemeCategory> listAllCategories() {
        return categoryRepository.findAll();
    }

    public MemeCategory findCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
