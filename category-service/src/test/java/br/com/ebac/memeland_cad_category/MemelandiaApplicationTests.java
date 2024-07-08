package br.com.ebac.memeland_cad_category;

import br.betereli.memeland.cad_category.MemelandiaApplication;
import br.betereli.memeland.cad_category.entities.MemeCategory;
import br.betereli.memeland.cad_category.repositories.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MemelandiaApplication.class )
class MemelandiaApplicationTests {

	@Autowired
	private CategoryRepository categoryRepository;

	@BeforeEach
	void setUp() {
		categoryRepository.deleteAll();
	}

	@DisplayName("Save Then Return Category List")
	@Test
	void SaveThenReturnCategoryList() {
		MemeCategory categoriaTest = new MemeCategory();
		categoriaTest.setName("Categoria Teste");
		categoriaTest.setDescription("Categoria para testar");
		categoriaTest.setRegistryDate(new Date());
		categoryRepository.save(categoriaTest);

		MemeCategory categoriaTest1 = new MemeCategory();
		categoriaTest1.setName("Categoria Teste 1");
		categoriaTest1.setDescription("Categoria para testar 1");
		categoriaTest1.setRegistryDate(new Date());
		categoryRepository.save(categoriaTest1);

		MemeCategory categoriaTest2 = new MemeCategory();
		categoriaTest2.setName("Categoria Teste 2");
		categoriaTest2.setDescription("Categoria para testar 2");
		categoriaTest2.setRegistryDate(new Date());
		categoryRepository.save(categoriaTest2);

		List<MemeCategory> memeCategoryList = categoryRepository.findAll();

		assertNotNull(memeCategoryList);
		assertEquals(3, memeCategoryList.size());
	}

	@DisplayName("Save Then Return New Category")
	@Test
	void SaveThenReturnNewCategory() {
		MemeCategory categoriaTest = new MemeCategory();
		categoriaTest.setName("Categoria Teste");
		categoriaTest.setDescription("Categoria para testar");
		categoriaTest.setRegistryDate(new Date());

		MemeCategory categoriaSalva = categoryRepository.save(categoriaTest);

		assertNotNull(categoriaSalva);
		assertTrue(categoriaSalva.getId() > 0);
	}

	@DisplayName("Save Then Return Category by Id")
	@Test
	void SaveThenReturnCategoryById() {
		MemeCategory categoriaTest = new MemeCategory();
		categoriaTest.setName("Categoria Teste");
		categoriaTest.setDescription("Categoria para testar");
		categoriaTest.setRegistryDate(new Date());

		categoryRepository.save(categoriaTest);

		MemeCategory categoriaSalva = categoryRepository.findById(categoriaTest.getId()).get();

		assertNotNull(categoriaSalva);
		assertEquals( categoriaTest.getId(), categoriaSalva.getId());
	}



}
