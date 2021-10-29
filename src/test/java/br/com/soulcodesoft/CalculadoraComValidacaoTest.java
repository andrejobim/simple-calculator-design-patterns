package br.com.soulcodesoft;

import br.com.soulcodesoft.commons.Calculadora;
import br.com.soulcodesoft.commons.CalcularValor;
import br.com.soulcodesoft.funcao.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.TRUE;

public class CalculadoraComValidacaoTest {

    private static List<String> sequenciaCalculoMatematico = Arrays.asList("*","/","+","-");
    private static List<BigDecimal> sequenciaValorCalculoCorrigido = new ArrayList<>();
    private static List<String> sequenciaCalculoCorrigido = new ArrayList<>();

    // Exammple: 10 * 10 + 20 - 15 / 2
    public static void main(String[] args) {
        args = (String[]) Arrays.asList("10","*","10","+","20","-","15","/","2").toArray();

        corrigirSequenciaMatematica(Arrays.asList(args));
        Calculadora calculadora = criarFuncaoCalculadoraRecursivo(sequenciaCalculoCorrigido, -1);
        CalcularValor calcularValor = new CalcularValor(sequenciaValorCalculoCorrigido);
        calculadora.calcular(calcularValor);
        System.out.println("Total: "+calcularValor.getTotal());
    }


    private static void corrigirSequenciaMatematica(List<String> sequenciaCalculoParametro){
        Boolean encontrouPrimeiraFuncao = Boolean.FALSE;
        for (int seqCalcPadrao = 0; seqCalcPadrao < sequenciaCalculoMatematico.size(); seqCalcPadrao++){
            String sequenciaPadrao = sequenciaCalculoMatematico.get(seqCalcPadrao);
            for (int seqCalcParam = 0; seqCalcParam < sequenciaCalculoParametro.size(); seqCalcParam++){
                String sequenciaParametro = sequenciaCalculoParametro.get(seqCalcParam);
                if (sequenciaPadrao.equals(sequenciaParametro) && !encontrouPrimeiraFuncao){
                    sequenciaValorCalculoCorrigido.add(getValorAnterior(sequenciaCalculoParametro, seqCalcParam));
                    sequenciaValorCalculoCorrigido.add(getValorPosterior(sequenciaCalculoParametro, seqCalcParam));
                    sequenciaCalculoCorrigido.add(sequenciaParametro);
                    encontrouPrimeiraFuncao = TRUE;
                } else if (encontrouPrimeiraFuncao && sequenciaPadrao.equals(sequenciaParametro)){
                    sequenciaValorCalculoCorrigido.add(getValorPosterior(sequenciaCalculoParametro, seqCalcParam));
                    sequenciaCalculoCorrigido.add(sequenciaParametro);
                }
            }
        }
        sequenciaCalculoCorrigido.add(".");
    }

    private static BigDecimal getValorAnterior(List<String> sequenciaCalculoParametro, Integer seqCalcParam){
        return BigDecimal.valueOf(Long.valueOf(sequenciaCalculoParametro.get(seqCalcParam-1)));
    }

    private static BigDecimal getValorPosterior(List<String> sequenciaCalculoParametro, Integer seqCalcParam){
        return BigDecimal.valueOf(Long.valueOf(sequenciaCalculoParametro.get(seqCalcParam+1)));
    }

    private static Calculadora criarFuncaoCalculadoraRecursivo(List<String> parametroFuncoes, Integer index){
        Calculadora calculadora = null;
        index++;
        if (parametroFuncoes.size()-1 >= index){
            switch (parametroFuncoes.get(index)){
                case "*":
                    calculadora = new CalcularMultiplicacao(criarFuncaoCalculadoraRecursivo(parametroFuncoes, index));
                    return calculadora;
                case "/":
                    calculadora = new CalcularDivisao(criarFuncaoCalculadoraRecursivo(parametroFuncoes, index));
                    return calculadora;
                case "+":
                    calculadora = new CalcularSoma(criarFuncaoCalculadoraRecursivo(parametroFuncoes, index));
                    return calculadora;
                case "-":
                    calculadora = new CalcularSubtracao(criarFuncaoCalculadoraRecursivo(parametroFuncoes, index));
                    return calculadora;
                case ".":
                    calculadora = new CalcularFim();
            }
        }
        return calculadora;
    }
}
