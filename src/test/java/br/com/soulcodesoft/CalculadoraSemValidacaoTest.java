package br.com.soulcodesoft;

import br.com.soulcodesoft.commons.CalcularValor;
import br.com.soulcodesoft.funcao.*;

import java.math.BigDecimal;

public class CalculadoraSemValidacaoTest {

    public static void main(String[] args) {
        CalcularValor calcularValor = new CalcularValor(BigDecimal.valueOf(10),
                BigDecimal.valueOf(10), BigDecimal.valueOf(10), BigDecimal.valueOf(10), BigDecimal.valueOf(10));

        new CalcularMultiplicacao(
                new CalcularDivisao(
                        new CalcularSoma(
                                new CalcularSubtracao(
                                        new CalcularFim()
                                )
                        )
                )
        ).calcular(calcularValor);

        System.out.println("Total: "+calcularValor.getTotal());
    }
}
