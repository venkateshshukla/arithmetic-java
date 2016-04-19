package in.vshukla.arithmetic;

import org.apache.commons.lang3.StringUtils;

import in.vshukla.arithmetic.exception.InvalidOperatorException;

/**
 * Created by venkatesh on 17/4/16.
 */
public enum Operator {
    ADD('+', "Addition"),
    SUBTRACT('-', "Subtraction"),
    MULTIPLY('x', "Multiplication"),
    DIVIDE('/', "Division");

    private char symbol;
    private String operation;

    private Operator(char symbol, String operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public static Operator fromChar(char op) throws InvalidOperatorException{
        for (Operator o : Operator.values()) {
            if (o.symbol == op) {
                return o;
            }
        }
        throw new InvalidOperatorException("Invalid operator : " + op);
    }
}
