package br.com.soulcodesoft.funcao;

import br.com.soulcodesoft.commons.Calculadora;
import br.com.soulcodesoft.commons.CalcularValor;

public class CalcularFim  extends Calculadora {

    public CalcularValor calcularValor;

    public CalcularFim() {
        super(null);
    }

    @Override
    public void calcular(CalcularValor calcularValor) {
        this.calcularValor = calcularValor;
    }
}
