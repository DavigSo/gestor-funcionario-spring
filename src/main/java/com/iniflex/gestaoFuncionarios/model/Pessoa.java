package com.iniflex.gestaoFuncionarios.model;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.time.LocalDate;

@Data
@MappedSuperclass
public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
}
