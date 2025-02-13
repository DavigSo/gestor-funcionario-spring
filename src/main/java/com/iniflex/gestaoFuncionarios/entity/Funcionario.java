package com.iniflex.gestaoFuncionarios.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "funcionarios")
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;
}