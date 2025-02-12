package com.iniflex.gestaoFuncionarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "funcionarios")
public class Funcionario extends Pessoa{
        private BigDecimal salario;
        private String funcao;
}
