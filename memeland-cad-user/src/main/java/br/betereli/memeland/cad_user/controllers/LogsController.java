package br.betereli.memeland.cad_user.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/logs")
public class LogsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogsController.class);

    @GetMapping
    public String showMessage(){
        final double message = Math.random();

        LOGGER.info("Gerei uma mensagem: {}", message);

        return "Mensagem e: " + message;
    }
}
