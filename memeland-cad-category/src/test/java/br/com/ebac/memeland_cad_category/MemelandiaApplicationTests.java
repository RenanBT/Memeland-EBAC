package br.com.ebac.memeland_cad_category;

import br.betereli.memeland.cad_category.MemelandiaApplication;
import br.betereli.memeland.cad_category.entities.CategoriaMeme;
import br.betereli.memeland.cad_category.repositories.RepositorioCategoriaMeme;
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
	private RepositorioCategoriaMeme repositorioCategoriaMeme;

	@BeforeEach
	void setUp() {
		repositorioCategoriaMeme.deleteAll();
	}

	@DisplayName("Save Then Return Category List")
	@Test
	void SaveThenReturnCategoryList() {
		CategoriaMeme categoriaTest = new CategoriaMeme();
		categoriaTest.setNome("Categoria Teste");
		categoriaTest.setDescricao("Categoria para testar");
		categoriaTest.setDataCadastro(new Date());
		repositorioCategoriaMeme.save(categoriaTest);

		CategoriaMeme categoriaTest1 = new CategoriaMeme();
		categoriaTest1.setNome("Categoria Teste 1");
		categoriaTest1.setDescricao("Categoria para testar 1");
		categoriaTest1.setDataCadastro(new Date());
		repositorioCategoriaMeme.save(categoriaTest1);

		CategoriaMeme categoriaTest2 = new CategoriaMeme();
		categoriaTest2.setNome("Categoria Teste 2");
		categoriaTest2.setDescricao("Categoria para testar 2");
		categoriaTest2.setDataCadastro(new Date());
		repositorioCategoriaMeme.save(categoriaTest2);

		List<CategoriaMeme> categoriaMemeList = repositorioCategoriaMeme.findAll();

		assertNotNull(categoriaMemeList);
		assertEquals(3, categoriaMemeList.size());
	}

	@DisplayName("Save Then Return New Category")
	@Test
	void SaveThenReturnNewCategory() {
		CategoriaMeme categoriaTest = new CategoriaMeme();
		categoriaTest.setNome("Categoria Teste");
		categoriaTest.setDescricao("Categoria para testar");
		categoriaTest.setDataCadastro(new Date());

		CategoriaMeme categoriaSalva = repositorioCategoriaMeme.save(categoriaTest);

		assertNotNull(categoriaSalva);
		assertTrue(categoriaSalva.getId() > 0);
	}

	@DisplayName("Save Then Return Category by Id")
	@Test
	void SaveThenReturnCategoryById() {
		CategoriaMeme categoriaTest = new CategoriaMeme();
		categoriaTest.setNome("Categoria Teste");
		categoriaTest.setDescricao("Categoria para testar");
		categoriaTest.setDataCadastro(new Date());

		repositorioCategoriaMeme.save(categoriaTest);

		CategoriaMeme categoriaSalva = repositorioCategoriaMeme.findById(categoriaTest.getId()).get();

		assertNotNull(categoriaSalva);
		assertEquals( categoriaTest.getId(), categoriaSalva.getId());
	}



}
