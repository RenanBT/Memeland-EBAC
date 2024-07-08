package br.betereli.memeland.cad_category.controllers;

import br.betereli.memeland.cad_category.entities.MemeCategory;
import br.betereli.memeland.cad_category.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memeland")
public class ControllerMemelandia {

    public Logger LOGGER = LoggerFactory.getLogger(ControllerMemelandia.class);

    @GetMapping("/cadcategory")
    public String teste(){

        return "Chamada Cad Category";
    }

    @Autowired
    private CategoryService categoryService;
    @GetMapping("/categories")
    public List<MemeCategory> findAllCategories() {
        LOGGER.info("Generated list with all categories: ");
        return categoryService.listAllCategories();
    }

    @GetMapping("/categories/{id}")
    public MemeCategory findCategoryById(@PathVariable Long id){
        LOGGER.info("Find category by Id: " + id);
        return categoryService.findCategoryById(id);
    }

   @PostMapping("/categories")
    public MemeCategory newCategory(@RequestBody MemeCategory memeCategory){
       LOGGER.info("Created new category Id: " + memeCategory.getId()+ " name: " + memeCategory.getName());
        return categoryService.newCategory(memeCategory);
   }

}
