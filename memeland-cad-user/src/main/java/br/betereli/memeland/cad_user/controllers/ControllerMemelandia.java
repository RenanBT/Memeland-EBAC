package br.betereli.memeland.cad_user.controllers;

import br.betereli.memeland.cad_user.entities.Usuario;
import br.betereli.memeland.cad_user.services.ServicoMemelandia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memeland/users")
public class ControllerMemelandia {

    @GetMapping("/caduser")
    public String teste(){
        return "Chamada Cad User";
    }

   @Autowired
    private ServicoMemelandia servicoMemelandia;

    @GetMapping
    public List<Usuario> buscaUsuarios() {
        return servicoMemelandia.listaTodosUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario findUserById(@PathVariable Long id){
        return servicoMemelandia.findUserById(id);
    }

    @PostMapping
    public Usuario novoUsuario(@RequestBody Usuario usuario) {
        return servicoMemelandia.novoUsuario(usuario);
    }






}
