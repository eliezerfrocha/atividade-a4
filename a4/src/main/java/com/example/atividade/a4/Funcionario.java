package com.example.atividade.a4;

public class Funcionario {
    private String nome;
    private Integer horasTrabalhadas;
    private Double valorHora;

    public Funcionario() {}

    public Funcionario(Integer horasTrabalhadas) {
        this.horasTrabalhadas = validaHora(horasTrabalhadas);
    }
    
    public Funcionario(String nome, Integer horasTrabalhadas, Double valorHora) {
        this.nome = validaNome(nome);
        this.horasTrabalhadas = validaHora(horasTrabalhadas);
        this.valorHora = validaValorHora(valorHora);
    }

    public Double calcularPagamento() {
        return getHorasTrabalhadas() * setValorHora();
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

    public Integer getHorasTrabalhadas() {
    
        return horasTrabalhadas;

    }

    public Double getValorHora() {
        // TODO Auto-generated method stub
        return valorHora;
    }

    public void setNome(String nome) {
        this.nome = validaNome(nome);
    }

    public String validaNome(String nome) {
        if (nome != null && !nome.trim().isEmpty() && nome.matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
            return nome;
        } else {
            throw new IllegalArgumentException("O nome não pode ser nulo, vazio ou conter caracteres inválidos.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setHorasTrabalhadas(Integer horasTrabalhadas) {
        this.horasTrabalhadas = validaHora(horasTrabalhadas);
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }
    
}
