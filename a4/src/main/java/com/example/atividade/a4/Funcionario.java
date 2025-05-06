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

    public double setValorHora() {
        return validaValorHora(valorHora);
    }

    public Double validaValorHora(Double valorHora) {
        double salarioMinimo = 1518.00;
        double minimo = salarioMinimo * 0.04;
        double maximo = salarioMinimo * 0.10;
    
        if (valorHora >= minimo && valorHora <= maximo) {
            return valorHora;
        } else {
            throw new IllegalArgumentException(String.format("O valor por hora deve estar entre %.2f e %.2f", minimo, maximo));
        }
    }
}
