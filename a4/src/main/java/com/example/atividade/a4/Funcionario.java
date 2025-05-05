package com.example.atividade.a4;

public class Funcionario {
    private String nome;
    private Integer horasTrabalhadas;
    private Double valorHora;

    public Funcionario() {
        //TODO Auto-generated constructor stub
    }

    public Funcionario(Integer horasTrabalhadas) {
        this.horasTrabalhadas = validaHora(horasTrabalhadas);
    }
    
    public Double calcularPagamento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPagamento'");
    }

    public Integer validaHora(Integer horasTrabalhadas){
        if (horasTrabalhadas >= 20 && horasTrabalhadas <= 40) {
            return horasTrabalhadas;
        }else{
            throw new IllegalArgumentException("As horas trabalhadas devem ser entre 20 e 40h");
        }
    }
}
