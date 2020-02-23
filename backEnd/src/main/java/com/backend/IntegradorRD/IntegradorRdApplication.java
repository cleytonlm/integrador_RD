package com.backend.IntegradorRD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegradorRdApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntegradorRdApplication.class, args);
	}

	/*
	@Bean
    CommandLineRunner init(ClienteRepository repository) {
        return args -> {
            repository.deleteAll();
            LongStream.range(1, 11)
                    .mapToObj(i -> {
                        Cliente c = new Cliente();
                        c.setNome("Cliente " + i);
                        c.setSobrenome("Cliente" + i + "sobrenome");
                        c.setEmail("Cliente" + i + "@email.com");
                        c.setSenha("Cliente" + i);
                        return c;
                    })
                    .map(v -> repository.save(v))
                    .forEach(System.out::println);
        };
    }
    */
    
}

