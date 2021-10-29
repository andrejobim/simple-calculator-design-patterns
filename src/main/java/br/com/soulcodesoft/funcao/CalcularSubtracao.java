package br.com.soulcodesoft.funcao;

import br.com.soulcodesoft.commons.Calculadora;
import br.com.soulcodesoft.commons.CalcularValor;

public class CalcularSubtracao extends Calculadora {

    public CalcularSubtracao(Calculadora proximo) {
        super(proximo);
    }

    @Override
    public void calcular(CalcularValor calcularValor) {
        calcularValor.setTotal(calcularValor.getPrimeiroValor()
                .subtract(calcularValor.getSegundoValor()));
        System.out.println("Subtração: "+calcularValor.getTotal());
        proximo.calcular(calcularValor);
    }

}
