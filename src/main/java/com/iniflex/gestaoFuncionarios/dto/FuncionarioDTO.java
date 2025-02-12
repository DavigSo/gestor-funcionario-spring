package com.iniflex.gestaoFuncionarios.dto;

import lombok.Data;

@Data
public class FuncionarioDTO {
    private String nome;
    private String dataNascimento;
    private String salario;
    private String funcao;
}
