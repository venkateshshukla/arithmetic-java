package in.vshukla.arithmetic;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

import in.vshukla.arithmetic.exception.InvalidOperatorException;
import in.vshukla.arithmetic.exception.InvalidParameterException;
import in.vshukla.arithmetic.exception.InvalidValueException;

/**
 * Created by venkatesh on 17/4/16.
 */
public class Arguments {
    private Integer range;
    private Integer numQuestions;
    private List<Operator> operatorList;

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Integer getNumQuestions() {
        return numQuestions;
    }

    public void setNumQuestions(Integer numQuestions) {
        this.numQuestions = numQuestions;
    }

    public List<Operator> getOperatorList() {
        return operatorList;
    }

    public void setOperatorList(List<Operator> operatorList) {
        this.operatorList = operatorList;
    }

    public void addOperator(String arg) throws InvalidOperatorException {
        this.operatorList.add(Operator.fromString(arg.trim()));
    }

    public void setNumQuestions(String arg) throws InvalidValueException {
        String s = arg.trim();
        if (StringUtils.isNotBlank(s)) {
            if (StringUtils.isNumeric(s)) {
                Integer i = Integer.valueOf(s);
                this.numQuestions = i;
            } else {
                throw new InvalidValueException("Invalid value for numQuestions : " + arg);
            }
        } else {
            throw new InvalidValueException("Empty value for numQuestions");
        }
    }

    public void setRange(String arg) throws InvalidValueException {
        String s = arg.trim();
        if (StringUtils.isNotBlank(s)) {
            if (StringUtils.isNumeric(s)) {
                Integer i = Integer.valueOf(s);
                this.range = i;
            } else {
                throw new InvalidValueException("Invalid value for range : " + arg);
            }
        } else {
            throw new InvalidValueException("Empty value for range");
        }
    }
}
