package br.betereli.memeland.cad_meme.clients;

import br.betereli.memeland.cad_meme.entities.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8084")
public interface UserClient {

    @GetMapping("/memeland/users/{id}")
    Usuario findUserById(@PathVariable("id") Long id);

}
