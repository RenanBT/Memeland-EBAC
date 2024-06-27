package br.betereli.memeland.cad_user.controllers;

import br.betereli.memeland.cad_user.entities.Usuario;
import br.betereli.memeland.cad_user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memeland")
public class UserController {

    public Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @GetMapping("/users/caduser")
    public String teste(){
        return "chamada cad user";
    }

   @Autowired
    private UserService userService;

    @GetMapping ("/users")
    public List<Usuario> buscaUsuarios() {
        return userService.listaTodosUsuarios();
    }

    @GetMapping("/users/{id}")
    public Usuario findUserById(@PathVariable Long id) {
        LOGGER.info("Chamada de usuario por id" + id);
        return userService.findUserById(id);
    }

    @PostMapping ("/users")
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        LOGGER.info("Criado novo usuario " + usuario.getNome());
        return userService.novoUsuario(usuario);
    }

}
