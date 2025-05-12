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
    @DisplayName("Calcular pagamento com dados válidos")
    public void testarCalculoHora() {
        // Arrange
        String nome = "João";
        Integer horasTrabalhadas = 30;
        Double valorHora = 100.00;
        funcionario = new Funcionario(nome, horasTrabalhadas, valorHora);

        // Act
        Double pagamento = funcionario.calcularPagamento();

        // Assert
        assertEquals(3000.00, pagamento);
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
                    funcionario = new Funcionario(entradaNome, entradaHoraInvalida, entradaValorhoraValida);
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

        // assing
        Integer saidaObtida = funcionario.getHorasTrabalhadas();

        assertEquals(saidaEsperada, saidaObtida);
    }

    // #region Testes para setValorHora()

    @Test
    @DisplayName("Valor da hora válido dentro dos limites permitidos")
    public void testarSetValorHoraValida() {
        funcionario = new Funcionario("Maria", 30, 70.00); // valor entre 60,72 e 151,80
        Double valorObtido = funcionario.setValorHora();
        assertEquals(70.00, valorObtido);
    }

    @Test
    @DisplayName("Valor da hora abaixo do mínimo permitido")
    public void testarSetValorHoraAbaixoLimite() {
        Double valorInvalido = 50.00;
        String mensagemEsperada = "O valor por hora deve estar entre 60.72 e 151.80";

        funcionario = new Funcionario("João", 25, valorInvalido);

        Throwable e = assertThrows(IllegalArgumentException.class, () -> funcionario.setValorHora());
        assertEquals(mensagemEsperada, e.getMessage());
    }

    @Test
    @DisplayName("Valor da hora acima do máximo permitido")
    public void testarSetValorHoraAcimaLimite() {
        Double valorInvalido = 200.00;
        String mensagemEsperada = "O valor por hora deve estar entre 60.72 e 151.80";

        funcionario = new Funcionario("Ana", 35, valorInvalido);

        Throwable e = assertThrows(IllegalArgumentException.class, () -> funcionario.setValorHora());
        assertEquals(mensagemEsperada, e.getMessage());
    }

    // #endregion

    // #region Teste calculaPagamento()

    @Test
    @DisplayName("Pagamento calculado corretamente com valores válidos")
    public void testarCalculoPagamentoValido() {
        funcionario = new Funcionario("Carlos", 30, 100.00); // 30 x 100 = 3000
        Double pagamento = funcionario.calcularPagamento();
        assertEquals(3000.00, pagamento);
    }

    @Test
    @DisplayName("Pagamento com valor da hora no limite inferior (mínimo permitido)")
    public void testarPagamentoComValorHoraMinimo() {
        double valorMinimo = 1518.00 * 0.04; // 60.72
        funcionario = new Funcionario("Beatriz", 20, valorMinimo); // 20 x 60.72 = 1214.4
        Double pagamento = funcionario.calcularPagamento();
        assertEquals(1214.4, pagamento);
    }

    @Test
    @DisplayName("Pagamento com valor da hora no limite superior (máximo permitido)")
    public void testarPagamentoComValorHoraMaximo() {
        double valorMaximo = 1518.00 * 0.10; // 151.80
        funcionario = new Funcionario("Pedro", 40, valorMaximo); // 40 x 151.80 = 6072
        Double pagamento = funcionario.calcularPagamento();
        assertEquals(6072.00, pagamento);
    }

    // #endregion
}
