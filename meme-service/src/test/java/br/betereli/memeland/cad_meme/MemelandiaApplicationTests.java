package br.betereli.memeland.cad_meme;

import br.betereli.memeland.cad_meme.entities.memeCategory;
import br.betereli.memeland.cad_meme.entities.Meme;
import br.betereli.memeland.cad_meme.entities.User;
import br.betereli.memeland.cad_meme.repositories.MemeRepository;
import br.betereli.memeland.cad_meme.services.MemelandService;
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
	private MemeRepository repositorioMeme;

	@InjectMocks
	private MemelandService memelandService;

	@Mock
	private User user;

	@Mock
	private memeCategory memeCategory;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	@DisplayName("Save then return new Meme")
	@Test
	void SaveThenReturnNewMeme() {
		when(user.getId()).thenReturn(1L);
		when(user.getNome()).thenReturn("UserTest");

		when(memeCategory.getId()).thenReturn(1L);
		when(memeCategory.getNome()).thenReturn("CategoryTest");

		Meme memeTest = new Meme();
		memeTest.setUsuario(user);
		memeTest.setCategoria(memeCategory);
		memeTest.setName("Meme Test");
		memeTest.setUrl("www.test.com");
		memeTest.setRegistryDate(new Date());

		Meme memeEntity = new Meme();
		memeEntity.setName(memeTest.getName());
		memeEntity.setUrl(memeTest.getUrl());
		memeEntity.setRegistryDate(memeTest.getRegistryDate());

		repositorioMeme.save(memeTest);


		when(repositorioMeme.save(memeEntity)).thenReturn(memeEntity);

		assertNotNull(user.getId());
		assertNotNull(memeCategory.getId());
		assertEquals("Meme Test", memeTest.getName());
		assertEquals("www.test.com", memeTest.getUrl());

	}

	@DisplayName("Save Then Return Meme List")
	@Test
	void SaveThenReturnMemeList(){

		when(user.getId()).thenReturn(1L);
		when(user.getNome()).thenReturn("UserTest");

		when(memeCategory.getId()).thenReturn(1L);
		when(memeCategory.getNome()).thenReturn("CategoryTest");

		Meme memeTest = new Meme();
		memeTest.setUsuario(user);
		memeTest.setCategoria(memeCategory);
		memeTest.setName("Meme Test");
		memeTest.setUrl("www.test.com");
		memeTest.setRegistryDate(new Date());
		repositorioMeme.save(memeTest);

		Meme memeTest1 = new Meme();
		memeTest1.setUsuario(user);
		memeTest1.setCategoria(memeCategory);
		memeTest1.setName("Meme Test 1");
		memeTest1.setUrl("www.test1.com");
		memeTest1.setRegistryDate(new Date());
		repositorioMeme.save(memeTest1);

		List<Meme> memeList = repositorioMeme.findAll();

		assertNotNull(memeList);
		assertEquals(2, memeList.size());


	}
}
