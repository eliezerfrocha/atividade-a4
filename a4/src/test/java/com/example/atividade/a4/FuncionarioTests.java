package com.example.atividade.a4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FuncionarioTests {
    private Funcionario funcionario;

    @BeforeEach
    public void instaciarClasseFuncionario(){
        funcionario = new Funcionario();
    }

    @Test
    public void testarCalculoHora(){
        Double pagamento = funcionario.calcularPagamento();
    }
}
