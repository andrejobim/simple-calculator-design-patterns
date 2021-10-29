package br.com.soulcodesoft.funcao;

import br.com.soulcodesoft.commons.Calculadora;
import br.com.soulcodesoft.commons.CalcularValor;

public class CalcularSoma extends Calculadora {

    public CalcularSoma(Calculadora proximo) {
        super(proximo);
    }

    @Override
    public void calcular(CalcularValor calcularValor) {
        calcularValor.setTotal(
                calcularValor.getPrimeiroValor()
                .add(calcularValor.getSegundoValor()));
        System.out.println("Soma: "+calcularValor.getTotal());
        proximo.calcular(calcularValor);
    }
}
