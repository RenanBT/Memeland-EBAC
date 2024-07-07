package br.betereli.memeland.cad_meme;

import br.betereli.memeland.cad_meme.entities.CategoriaMeme;
import br.betereli.memeland.cad_meme.entities.Meme;
import br.betereli.memeland.cad_meme.entities.Usuario;
import br.betereli.memeland.cad_meme.repositories.RepositorioMeme;
import br.betereli.memeland.cad_meme.services.ServicoMemelandia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = MemelandiaApplication.class)
class MemelandiaApplicationTests {

	@Mock
	private RepositorioMeme repositorioMeme;

	@InjectMocks
	private ServicoMemelandia servicoMemelandia;

	@Mock
	private Usuario usuario;

	@Mock
	private CategoriaMeme categoriaMeme;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	@DisplayName("Save then return new Meme")
	@Test
	void SaveThenReturnNewMeme() {
		when(usuario.getId()).thenReturn(1L);
		when(usuario.getNome()).thenReturn("UserTest");

		when(categoriaMeme.getId()).thenReturn(1L);
		when(categoriaMeme.getNome()).thenReturn("CategoryTest");

		Meme memeTest = new Meme();
		memeTest.setUsuario(usuario);
		memeTest.setCategoria(categoriaMeme);
		memeTest.setNome("Meme Test");
		memeTest.setUrl("www.test.com");
		memeTest.setDataCadastro(new Date());

		Meme memeEntity = new Meme();
		memeEntity.setNome(memeTest.getNome());
		memeEntity.setUrl(memeTest.getUrl());
		memeEntity.setDataCadastro(memeTest.getDataCadastro());

		repositorioMeme.save(memeTest);


		when(repositorioMeme.save(memeEntity)).thenReturn(memeEntity);

		assertNotNull(usuario.getId());
		assertNotNull(categoriaMeme.getId());
		assertEquals("Meme Test", memeTest.getNome());
		assertEquals("www.test.com", memeTest.getUrl());

	}

	@DisplayName("Save Then Return Meme List")
	@Test
	void SaveThenReturnMemeList(){

		when(usuario.getId()).thenReturn(1L);
		when(usuario.getNome()).thenReturn("UserTest");

		when(categoriaMeme.getId()).thenReturn(1L);
		when(categoriaMeme.getNome()).thenReturn("CategoryTest");

		Meme memeTest = new Meme();
		memeTest.setUsuario(usuario);
		memeTest.setCategoria(categoriaMeme);
		memeTest.setNome("Meme Test");
		memeTest.setUrl("www.test.com");
		memeTest.setDataCadastro(new Date());
		repositorioMeme.save(memeTest);

		Meme memeTest1 = new Meme();
		memeTest1.setUsuario(usuario);
		memeTest1.setCategoria(categoriaMeme);
		memeTest1.setNome("Meme Test 1");
		memeTest1.setUrl("www.test1.com");
		memeTest1.setDataCadastro(new Date());
		repositorioMeme.save(memeTest1);

		List<Meme> memeList = repositorioMeme.findAll();

		assertNotNull(memeList);
		assertEquals(2, memeList.size());


	}
}
