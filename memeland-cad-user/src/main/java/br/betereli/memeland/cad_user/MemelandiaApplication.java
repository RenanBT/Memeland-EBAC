package br.betereli.memeland.cad_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//docker run -d -p 9411:9411 openzipkin/zipkin
@SpringBootApplication
public class MemelandiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemelandiaApplication.class, args);
	}

}
