package com.example.atividade.a4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FuncionarioTests {
    private Funcionario funcionario;

    @BeforeEach
    public void instaciarClasseFuncionario() {
        funcionario = new Funcionario();
    }

    @Test
     public void testarCalculoHora() {
         Double pagamento = funcionario.calcularPagamento();
    }


    @Test
    @DisplayName("Caso de testes em que é inserido um valor de hora invalida")
    public void testarConstrutorEntradaValorHoraInvalida() {
        // Arrange
        Integer entradaHoraInvalida = 41;
        String entradaNome = "Jose";
        Double entradaValorhoraValida = 61.55;
        String mensagemEsperada = "As horas trabalhadas devem ser entre 20 e 40h";

        // act
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    funcionario = new Funcionario(entradaNome,entradaHoraInvalida,entradaValorhoraValida);
                });
        assertEquals(mensagemEsperada, e.getMessage());
    }

    @Test
    @DisplayName("Caso de testes em que é inserido um valor de hora menor que 20h")
    public void testarConstrutorEntradaValorHoraInvalidaLimiteInferior() {
        // Arrange
        Integer entradaInvalida = 19;
        String mensagemEsperada = "As horas trabalhadas devem ser entre 20 e 40h";

        // act
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    funcionario = new Funcionario(entradaInvalida);
                });
        assertEquals(mensagemEsperada, e.getMessage());
    }


    @Test
    @DisplayName("Caso de testes em que é inserido um valor de hora valido entre 20 e 40")
    public void testarConstrutorEntradaValorHoraValida() {
        // Arrange
        Integer entradaValida = 21;
        Integer saidaEsperada = 21;

        // act
        
      funcionario = new Funcionario(entradaValida);

      //assing
      Integer saidaObtida = funcionario.getHorasTrabalhadas();
                
        assertEquals(saidaEsperada, saidaObtida);
    }
}
