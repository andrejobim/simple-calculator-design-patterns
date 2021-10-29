package br.com.soulcodesoft.funcao;

import br.com.soulcodesoft.commons.Calculadora;
import br.com.soulcodesoft.commons.CalcularValor;

public class CalcularMultiplicacao extends Calculadora {

    public CalcularMultiplicacao(Calculadora proximo) {
        super(proximo);
    }

    @Override
    public void calcular(CalcularValor calcularValor) {
        calcularValor.setTotal(calcularValor.getPrimeiroValor()
                .multiply(calcularValor.getSegundoValor()));
        System.out.println("Multiplicação: "+calcularValor.getTotal());
        proximo.calcular(calcularValor);
    }
}
