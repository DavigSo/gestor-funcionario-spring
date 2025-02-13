package com.iniflex.gestaoFuncionarios.service;

import com.iniflex.gestaoFuncionarios.entity.Funcionario;
import com.iniflex.gestaoFuncionarios.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

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
            funcionario.setSalario(funcionario.getSalario().multiply(BigDecimal.valueOf((1 + parcent / 100))));
            funcionarioRepository.save(funcionario);
        });
    }

}
