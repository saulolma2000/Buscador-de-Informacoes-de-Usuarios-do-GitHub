package com.example.ProjetoHttp;

import org.springframework.boot.SpringApplication;

public class TestProjetoHttpApplication {

	public static void main(String[] args) {
		SpringApplication.from(ProjetoHttpApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
