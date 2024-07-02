package br.com.ebac.memelandia;

import br.betereli.memeland.cad_user.MemelandiaApplication;
import br.betereli.memeland.cad_user.entities.Usuario;
import br.betereli.memeland.cad_user.repositories.RepositorioUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MemelandiaApplication.class)
class MemelandiaApplicationTests {

	@Autowired
	private RepositorioUsuario repositorioUsuario;
	@DisplayName("Save Then Return New User")
	@Test
	void testSaveThenReturnNewUser() {
		Usuario userTest = new Usuario();
		userTest.setNome("Renan");
		userTest.setEmail("renan@test.com");
		userTest.setDataCadastro(new Date());

		Usuario usuarioSalvo = repositorioUsuario.save(userTest);

		assertNotNull(usuarioSalvo);
		assertTrue(usuarioSalvo.getId() > 0);

	}

	@DisplayName("Save Then Return User List")
	@Test
	void testSaveThenReturnList() {
		Usuario userTest = new Usuario();
		userTest.setNome("Renan");
		userTest.setEmail("renan@test.com");
		userTest.setDataCadastro(new Date());
		repositorioUsuario.save(userTest);

		Usuario userTest1 = new Usuario();
		userTest1.setNome("Tais");
		userTest1.setEmail("tais@test.com");
		userTest1.setDataCadastro(new Date());
		repositorioUsuario.save(userTest1);

		Usuario userTest2 = new Usuario();
		userTest2.setNome("Luisa");
		userTest2.setEmail("luisa@test.com");
		userTest2.setDataCadastro(new Date());


		repositorioUsuario.save(userTest2);

		List<Usuario> usuarioList = repositorioUsuario.findAll();

		assertNotNull(usuarioList);
		assertEquals(3 , usuarioList.size());

	}

	@DisplayName("Save Then Return User by Id")
	@Test
	void testSaveThenReturnUserById() {
		Usuario userTest = new Usuario();
		userTest.setNome("Renan");
		userTest.setEmail("renan@test.com");
		userTest.setDataCadastro(new Date());

		repositorioUsuario.save(userTest);

		Usuario usuarioSalvo = repositorioUsuario.findById(userTest.getId()).get();

		assertNotNull(usuarioSalvo);
		assertEquals(userTest.getId() ,usuarioSalvo.getId());

	}


	/*


    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "data_cadastro", nullable = false)
    private Date dataCadastro;
	 */

}
