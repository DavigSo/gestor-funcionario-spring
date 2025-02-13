package com.iniflex.gestaoFuncionarios.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "funcionarios")
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public BigDecimal getSalario() {
        return this.salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

}