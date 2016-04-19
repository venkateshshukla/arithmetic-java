package in.vshukla.arithmetic;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.vshukla.arithmetic.exception.InvalidOperatorException;
import in.vshukla.arithmetic.exception.InvalidValueException;

/**
 * Created by venkatesh on 17/4/16.
 */
public class Arguments {
    private int range;
    private int numQuestions;
    private List<Operator> operatorList;

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setRange(String arg) throws InvalidValueException {
        if (StringUtils.isNotBlank(arg)) {
            String s = arg.trim();
            try {
                int i = Integer.valueOf(s);
                setRange(i);
            } catch(NumberFormatException e) {
                throw new InvalidValueException("Invalid value for range : " + s);
            }
        } else {
            throw new InvalidValueException("Empty value for range");
        }
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(int numQuestions) throws InvalidValueException {
        if (numQuestions < 0) {
            throw new InvalidValueException("Number of questions cannot be negative.");
        }
        this.numQuestions = numQuestions;
    }

    public void setNumQuestions(String arg) throws InvalidValueException {
        if (StringUtils.isNotBlank(arg)) {
            String s = arg.trim();
            try {
                int i = Integer.valueOf(s);
                setNumQuestions(i);
            } catch(NumberFormatException e) {
                throw new InvalidValueException("Invalid value for numQuestions : " + s);
            }
        } else {
            throw new InvalidValueException("Empty value for numQuestions");
        }
    }

    public List<Operator> getOperatorList() {
        return operatorList;
    }

    public String getOperatorString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Operator> iter = this.operatorList.iterator();
        while(iter.hasNext()) {
            sb.append(iter.next().getSymbol());
        }
        return sb.toString();
    }

    public void setOperatorList(List<Operator> operatorList) throws InvalidValueException {
        if (operatorList == null || operatorList.isEmpty()) {
            throw new InvalidValueException("OperatorList cannot be empty");
        }
        this.operatorList = operatorList;
    }

    public void setOperatorString(String opList) throws InvalidValueException {
        if (StringUtils.isBlank(opList)) {
            throw new InvalidValueException("OperatorList cannot be empty");
        }
        String ops = opList.trim();
        this.operatorList = new ArrayList<>();
        for (int i = 0; i < ops.length(); i++) {
            Operator o = Operator.fromChar(ops.charAt(i));
            this.operatorList.add(o);
        }
    }

    public void addOperator(String op) throws InvalidValueException {
        if (StringUtils.isBlank(op)) {
            throw new InvalidValueException("Operator string is null or blank.");
        }
        if (op.length() != 1) {
            throw new InvalidValueException("Operator string must be of length 1.");
        }
        addOperator(op.charAt(0));
    }

    public void addOperator(char op) throws InvalidOperatorException {
        if (this.operatorList == null) {
            this.operatorList = new ArrayList<>();
        }
        this.operatorList.add(Operator.fromChar(op));
    }
}
