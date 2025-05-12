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
                    funcionario = new Funcionario(entradaNome, entradaHoraInvalida, entradaValorhoraValida);
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

    // @Test
    // @DisplayName("Caso de testes em que é inserido valores validos")
    // public void testarConstrutorEntradasValidas() {
    //     // Arrange
    //     String entradaNomeValido = "Jose";
    //     Integer entradaHorasTrabalhadasValida = 21;
    //     Double entradaValorHoraValida = 61.55;

    //     Integer SaidaEsperadaHorasTrabalhadas = 21;
    //     Double saidaEsperadaValorHora = 61.55;

    //     // act
    //     funcionario = new Funcionario(entradaValida);

    //     // assing
    //     Integer saidaObtida = funcionario.getHorasTrabalhadas();

    //     assertEquals(saidaEsperada, saidaObtida);
    // }

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
        String mensagemEsperada = "O valor por hora deve estar entre 60,72 e 151,80";

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

    @Test
    @DisplayName("Caso de teste caso o nome seja vazio")
    public void testarValidacaoDeNomeVazio() {
        // Arrange
        String entradaNomeVazio = "";
        String mensagemEsperada = "O nome não pode ser nulo, vazio ou conter caracteres inválidos.";

        // act
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    funcionario.setNome(entradaNomeVazio);
                });
        assertEquals(mensagemEsperada, e.getMessage());
    }


    @Test
    @DisplayName("Caso de teste caso o nome contenha caracteres inválidos.")
    public void testarValidacaoDeNomeCaracteresInvalido() {
        // Arrange
        String entradaNomeVazio = "Jo@o123";
        String mensagemEsperada = "O nome não pode ser nulo, vazio ou conter caracteres inválidos.";

        // act
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    funcionario.setNome(entradaNomeVazio);
                });
        assertEquals(mensagemEsperada, e.getMessage());
    }

    @Test
    @DisplayName("Caso de teste caso o nome seja nulo")
    public void testarValidacaoDeNomeNulo() {
        // Arrange
        String entradaNomeVazio = null;
        String mensagemEsperada = "O nome não pode ser nulo, vazio ou conter caracteres inválidos.";

        // act
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    funcionario.setNome(entradaNomeVazio);
                });
        assertEquals(mensagemEsperada, e.getMessage());
    }

    @Test
    @DisplayName("Caso de teste caso o nome seja valido")
    public void testarValidacaoDeNomeValido() {
        // Arrange
        String entradaNomevalido = "Jose";
        String saidaEsperada = "Jose" ;

        // act
        funcionario.setNome(entradaNomevalido);

        //assign

        String saidaObtida = funcionario.getNome();
        
        assertEquals(saidaEsperada, saidaObtida);
    }

    @Test
    @DisplayName("Caso de teste caso as horas trabalhadas sejam maior que 40")
    public void testarValidacaoHorasTrabalhadasMaior(){
        //Arrange
        Integer entradaHorasMaior = 41;
        String mensagemEsperada = "As horas trabalhadas devem ser entre 20 e 40h";
        // act
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    funcionario.setHorasTrabalhadas(entradaHorasMaior);
                });
        assertEquals(mensagemEsperada, e.getMessage());        
    }

    @Test
    @DisplayName("Caso de teste caso as horas trabalhadas sejam menor que 20")
    public void testarValidacaoHorasTrabalhadasMenor(){
        //Arrange
        Integer entradaHorasMenor = 19;
        String mensagemEsperada = "As horas trabalhadas devem ser entre 20 e 40h";
        // act
        Throwable e = assertThrows(IllegalArgumentException.class,
                () -> {
                    funcionario.setHorasTrabalhadas(entradaHorasMenor);
                });
        assertEquals(mensagemEsperada, e.getMessage());        
    }

    @Test
    @DisplayName("Caso de teste caso as horas trabalhadas sejam validas")
    public void testarValidacaoHorasTrabalhadasValidas(){
        //Arrange
        Integer entradaHorasvalidas = 25;
        Integer saidaEsperada = 25;
        // act
        funcionario.setHorasTrabalhadas(entradaHorasvalidas);
        //assign
        Integer saidaObtida = funcionario.getHorasTrabalhadas();
        assertEquals(saidaEsperada, saidaObtida);        
    }
}
