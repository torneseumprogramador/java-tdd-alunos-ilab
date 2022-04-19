package com.br.testes.poc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.br.testes.poc.models.Cliente;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PocApplicationTests {

	@Test
	void validarCPFValido() {
		var cliente = new Cliente();
		cliente.setCpf("030.750.650-99");

		//assertEquals(true, cliente.cpfValido());
		assertTrue(cliente.cpfValido());
	}

	@Test
	void validarCPFValidoSemPontos() {
		var cliente = new Cliente();
		cliente.setCpf("03075065099");

		assertTrue(cliente.cpfValido());
	}

	@Test
	void validarCPFInvalido() {
		var cliente = new Cliente();
		cliente.setCpf("030.750.650-00");

		assertFalse(cliente.cpfValido());
	}

	@Test
	void validarCPFInvalidoSemPonto() {
		var cliente = new Cliente();
		cliente.setCpf("03075065000");

		assertFalse(cliente.cpfValido());
	}

	@Test
	void validarCPFInvalidoComTexto() {
		var cliente = new Cliente();
		cliente.setCpf("dsdsd");

		assertFalse(cliente.cpfValido());
	}


	@Test
	void validarCPFInvalidoEmBranco() {
		var cliente = new Cliente();
		cliente.setCpf("");

		assertFalse(cliente.cpfValido());
	}

	@Test
	void validarCPFInvalidoNull() {
		var cliente = new Cliente();
		cliente.setCpf(null);

		assertFalse(cliente.cpfValido());
	}
}
