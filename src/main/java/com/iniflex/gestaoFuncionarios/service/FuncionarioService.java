package com.iniflex.gestaoFuncionarios.service;

import com.iniflex.gestaoFuncionarios.entity.Funcionario;
import com.iniflex.gestaoFuncionarios.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    public double getSalario;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    
    public Funcionario createFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public String deleteFuncionario(Long id) {
        funcionarioRepository.deleteById(Long.valueOf(id));
        return "Funcionario deletado com sucesso!";
    }

    public void increaseSalaries(double parcent) {
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        funcionarios.forEach(funcionario -> {
            funcionario.setSalario(funcionario.getSalario()
                    .multiply(BigDecimal.valueOf((1 + parcent / 100))));
            funcionarioRepository.save(funcionario);
        });
    }

    public Map<String, List<Funcionario>> groupByFunction() {
        return funcionarioRepository.findAll().stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public List<Funcionario> getFuncionariosByBirthdayMonths(List<Integer> meses) {
        return funcionarioRepository.findAll().stream()
                .filter(f -> meses.contains(f.getDataNascimento().getMonthValue()))
                .collect(Collectors.toList());
    }

    public Funcionario getOldestFuncionario() {
        return funcionarioRepository.findAll().stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
    }

    public List<Funcionario> getFuncionariosOrderedsByName() {
        return funcionarioRepository.findAll().stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
    }

    public BigDecimal getTotalSalaries() {
        return funcionarioRepository.findAll().stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<String, BigDecimal> getMinimumWageMultiples(BigDecimal salarioMinimo) {
        return funcionarioRepository.findAll().stream()
                .collect(Collectors.toMap(
                        Funcionario::getNome,
                        f -> f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP)
                ));
    }
}
