package br.com.soulcodesoft.commons;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CalcularValor {

    private BigDecimal total;
    private Integer index;
    private final List<BigDecimal> valores;

    public BigDecimal getTotal(){
        return this.total == null ? BigDecimal.ZERO : this.total;
    }

    public CalcularValor(List<BigDecimal> valores) {
        this.total = BigDecimal.ZERO;
        this.index = -1;
        this.valores = valores;
    }

    public CalcularValor(BigDecimal ... valor) {
        this.total = BigDecimal.ZERO;
        this.index = -1;
        this.valores = Arrays.asList(valor);
    }

    public Integer next(){
        this.index++;
        return this.index;
    }

    public List<BigDecimal> getValores() {
        return this.valores;
    }

    public BigDecimal getSegundoValor(){
        return getProximoValor();
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getPrimeiroValor(){
        if (this.total.compareTo(BigDecimal.ZERO) != 0){
            return this.total;
        }
        return getProximoValor();
    }

    private BigDecimal getProximoValor(){
        Integer index = next();
        if (possuiIndexValido(index)){
            return getValor(index);
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal getValor(Integer index) {
        return this.getValores().get(index);
    }

    private boolean possuiIndexValido(Integer index) {
        return this.getValores().size() - 1 >= index;
    }

}
