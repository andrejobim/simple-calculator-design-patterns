package br.com.soulcodesoft.commons;

public abstract class Calculadora {

    protected Calculadora proximo;

    public Calculadora(Calculadora proximo) {
        this.proximo = proximo;
    }

    public abstract void calcular(CalcularValor calcularValor);

}
