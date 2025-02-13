package com.iniflex.gestaoFuncionarios.controller;

import com.iniflex.gestaoFuncionarios.entity.Funcionario;
import com.iniflex.gestaoFuncionarios.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

    @GetMapping("/por-funcao")
    public ResponseEntity<Map<String, List<Funcionario>>> groupByFunction() {
        try {
            funcionarioService.groupByFunction();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/aniversariantes")
    public ResponseEntity<List<Funcionario>> getFuncionariosByBirthdayMonths(@RequestParam List<Integer> meses) {
        try {
            funcionarioService.getFuncionariosByBirthdayMonths(meses);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/mais-velho")
    public ResponseEntity<Funcionario>getOldestFuncionario(){
        try {
            funcionarioService.getOldestFuncionario();
            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/ordenados-alfabeticamente")
    public ResponseEntity<List<Funcionario>> getFuncionariosOrderedsByName() {
        try {
            List<Funcionario> funcionarios = funcionarioService.getFuncionariosOrderedsByName();
            return new ResponseEntity<>(funcionarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/total-salarios")
    public ResponseEntity<String> getTotalSalaries() {
        try {
            Locale locale = new Locale("pt", "BR");
            NumberFormat numberFormat = NumberFormat.getInstance(locale);
            numberFormat.setMinimumFractionDigits(2);
            numberFormat.setMaximumFractionDigits(2);
            String formattedTotal = numberFormat.format(funcionarioService.getTotalSalaries());
            return new ResponseEntity<>(formattedTotal, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/salarios-minimos")
    public ResponseEntity<Map<String, BigDecimal>> getMinimumWageMultiples() {
        try {
            BigDecimal salarioMinimo = new BigDecimal("1212.00");
            return ResponseEntity.ok(funcionarioService.getMinimumWageMultiples(salarioMinimo));

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
