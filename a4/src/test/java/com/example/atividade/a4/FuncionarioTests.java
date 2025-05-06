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
    @DisplayName("Caso de testes em que é inserido um valor de horas trabalhadas invalida")
    public void testarConstrutorEntradahorasTrabalhadasInvalida() {
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
    @DisplayName("Caso de testes em que é inserido um valor de valorHora invalido")
    public void testarConstrutorEntradaValorHoraInvalido() {
        // Arrange
        Integer entradaHoraValida = 40;
        String entradaNome = "Jose";
        Double entradaValorhoraInvalido = 15.00;
        String mensagemEsperada = "O valor por hora deve estar entre 60,72 e 151,80";

        // act
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    funcionario = new Funcionario(entradaNome,entradaHoraValida,entradaValorhoraInvalido);
                });
        assertEquals(mensagemEsperada, e.getMessage());
    }


    @Test
    @DisplayName("Caso de testes em que é inserido valores validos")
    public void testarConstrutorEntradasValidas() {
        // Arrange
        String entradaNomeValido = "Jose";
        Integer entradaHorasTrabalhadasValida = 21;
        Double entradaValorHoraValida = 61.55;

        Integer SaidaEsperadaHorasTrabalhadas = 21;
        Double saidaEsperadaValorHora = 61.55;

        // act
        
      funcionario = new Funcionario(entradaNomeValido,entradaHorasTrabalhadasValida,entradaValorHoraValida);

      //assing
      Integer saidaHorasTrabalhadas = funcionario.getHorasTrabalhadas();
      Double saidaValorHora = funcionario.getValorHora();
                
        assertEquals(SaidaEsperadaHorasTrabalhadas, saidaHorasTrabalhadas);
        assertEquals(saidaEsperadaValorHora, saidaValorHora);
    }
}
