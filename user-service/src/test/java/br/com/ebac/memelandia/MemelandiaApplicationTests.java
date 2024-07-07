package br.com.ebac.memelandia;

import br.betereli.memeland.cad_user.MemelandiaApplication;
import br.betereli.memeland.cad_user.entities.User;
import br.betereli.memeland.cad_user.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MemelandiaApplication.class)
class MemelandiaApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@DisplayName("Save Then Return New User")
	@Test
	void testSaveThenReturnNewUser() {
		User userTest = new User();
		userTest.setName("Renan");
		userTest.setEmail("renan@test.com");
		userTest.setRegistryDate(new Date());

		User userSalvo = userRepository.save(userTest);

		assertNotNull(userSalvo);
		assertTrue(userSalvo.getId() > 0);

	}

	@DisplayName("Save Then Return User List")
	@Test
	void testSaveThenReturnList() {
		User userTest = new User();
		userTest.setName("Renan");
		userTest.setEmail("renan@test.com");
		userTest.setRegistryDate(new Date());
		userRepository.save(userTest);

		User userTest1 = new User();
		userTest1.setName("Tais");
		userTest1.setEmail("tais@test.com");
		userTest1.setRegistryDate(new Date());
		userRepository.save(userTest1);

		User userTest2 = new User();
		userTest2.setName("Luisa");
		userTest2.setEmail("luisa@test.com");
		userTest2.setRegistryDate(new Date());
		userRepository.save(userTest2);

		List<User> userList = userRepository.findAll();

		assertNotNull(userList);
		assertEquals(3 , userList.size());

	}

	@DisplayName("Save Then Return User by Id")
	@Test
	void testSaveThenReturnUserById() {
		User userTest = new User();
		userTest.setName("Renan");
		userTest.setEmail("renan@test.com");
		userTest.setRegistryDate(new Date());

		userRepository.save(userTest);

		User userSalvo = userRepository.findById(userTest.getId()).get();

		assertNotNull(userSalvo);
		assertEquals(userTest.getId() , userSalvo.getId());

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
