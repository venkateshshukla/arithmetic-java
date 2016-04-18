package in.vshukla.arithmetic;

import org.apache.commons.lang3.StringUtils;

import in.vshukla.arithmetic.exception.InvalidOperatorException;

/**
 * Created by venkatesh on 17/4/16.
 */
public enum Operator {
    ADD("+", "Addition"),
    SUBTRACT("-", "Subtraction"),
    MULTIPLY("x", "Multiplication"),
    DIVIDE("/", "Division");

    private String symbol;
    private String operation;

    private Operator(String symbol, String operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public static Operator fromString(String op) throws InvalidOperatorException{
        if (StringUtils.isNotBlank(op)) {
            for (Operator o : Operator.values()) {
                if (o.symbol.equals(op)) {
                    return o;
                }
            }
            throw new InvalidOperatorException("Invalid operator : " + op);
        } else {
            throw new InvalidOperatorException("Empty operator");
        }
    }
}
