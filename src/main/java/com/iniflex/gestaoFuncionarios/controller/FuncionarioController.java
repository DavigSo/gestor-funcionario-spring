package com.iniflex.gestaoFuncionarios.controller;

import com.iniflex.gestaoFuncionarios.entity.Funcionario;
import com.iniflex.gestaoFuncionarios.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")

public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario) {
        try {

            Funcionario savedFuncionario = funcionarioService.createFuncionario(funcionario);
            return new ResponseEntity<>(savedFuncionario, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAllFuncionarios() {
        try {
            List<Funcionario> funcionarios = funcionarioService.getAllFuncionarios();
            return new ResponseEntity<>(funcionarios, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFuncionario(@PathVariable Long id) {
        try {
           String mensagem = this.funcionarioService.deleteFuncionario(id);
           return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/aumento")
    public ResponseEntity<Void> increaseSalaries() {
        try {
            funcionarioService.increaseSalaries(10);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
