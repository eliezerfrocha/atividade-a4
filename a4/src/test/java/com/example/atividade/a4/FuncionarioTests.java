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
