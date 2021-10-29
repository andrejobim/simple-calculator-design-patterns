package br.com.soulcodesoft.funcao;

import br.com.soulcodesoft.commons.Calculadora;
import br.com.soulcodesoft.commons.CalcularValor;

public class CalcularDivisao extends Calculadora {

    public CalcularDivisao(Calculadora proximo) {
        super(proximo);
    }

    @Override
    public void calcular(CalcularValor calcularValor) {
        calcularValor.setTotal(calcularValor.getPrimeiroValor()
                .divide(calcularValor.getSegundoValor()));
        System.out.println("Divisão: "+calcularValor.getTotal());
        proximo.calcular(calcularValor);
    }

}
