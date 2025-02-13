package com.iniflex.gestaoFuncionarios;

import com.iniflex.gestaoFuncionarios.entity.Funcionario;
import com.iniflex.gestaoFuncionarios.repository.FuncionarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class GestaoFuncionariosApplication implements CommandLineRunner {

	private final FuncionarioRepository funcionarioRepository;

	public GestaoFuncionariosApplication(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(GestaoFuncionariosApplication.class, args);
	}

	// Esses dados são testados via postman
	@Override
	public void run(String... args) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		funcionarioRepository.save(
				Funcionario.builder()
						.nome("Maria")
						.dataNascimento(LocalDate.parse("18/10/2000", formatter))
						.salario(new BigDecimal("2009.44"))
						.funcao("Operador")
						.build()
		);

		funcionarioRepository.save(
				Funcionario.builder()
						.nome("João")
						.dataNascimento(LocalDate.parse("12/05/1990", formatter))
						.salario(new BigDecimal("2284.38"))
						.funcao("Operador")
						.build()
		);


		funcionarioRepository.save(
				Funcionario.builder()
						.nome("Caio")
						.dataNascimento(LocalDate.parse("02/05/1961", formatter))
						.salario(new BigDecimal("9836.14"))
						.funcao("Coordenador")
						.build()
		);

		funcionarioRepository.save(
				Funcionario.builder()
						.nome("Miguel")
						.dataNascimento(LocalDate.parse("14/10/1988", formatter))
						.salario(new BigDecimal("19119.88"))
						.funcao("Diretor")
						.build()
		);

		funcionarioRepository.save(
				Funcionario.builder()
						.nome("Alice")
						.dataNascimento(LocalDate.parse("05/01/1995", formatter))
						.salario(new BigDecimal("2234.68"))
						.funcao("Recepcionista")
						.build()
		);

		funcionarioRepository.save(
				Funcionario.builder()
						.nome("Heitor")
						.dataNascimento(LocalDate.parse("19/11/1999", formatter))
						.salario(new BigDecimal("1582.72"))
						.funcao("Operador")
						.build()
		);

		funcionarioRepository.save(
				Funcionario.builder()
						.nome("Arthur")
						.dataNascimento(LocalDate.parse("31/03/1993", formatter))
						.salario(new BigDecimal("4071.84"))
						.funcao("Contador")
						.build()
		);

		funcionarioRepository.save(
				Funcionario.builder()
						.nome("Laura")
						.dataNascimento(LocalDate.parse("08/07/1994", formatter))
						.salario(new BigDecimal("3017.45"))
						.funcao("Gerente")
						.build()
		);

		funcionarioRepository.save(
				Funcionario.builder()
						.nome("Heloísa")
						.dataNascimento(LocalDate.parse("24/05/2003", formatter))
						.salario(new BigDecimal("1606.85"))
						.funcao("Eletricista")
						.build()
		);

		funcionarioRepository.save(
				Funcionario.builder()
						.nome("Helena")
						.dataNascimento(LocalDate.parse("02/09/1996", formatter))
						.salario(new BigDecimal("2799.93"))
						.funcao("Gerente")
						.build()
		);


	}


}
