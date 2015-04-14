package org.arithmetic;

import java.lang.String;

import org.arithmetic.OperatorList;
import org.arithmetic.PenaltyMap;
import org.arithmetic.Stats;
import org.arithmetic.exception.AppException;

public class Session {

    short numQues;
    int maxRange;
    OperatorList opList;
    Stats stats;
    PenaltyMap penMap;

    public void setMaxRange(int r) throws AppException {
        if (r <= 0) {
            throw new AppException("Max range should be positive.");
        }
        this.maxRange = r;
    }

    public int getMaxRange() {
        return this.maxRange;
    }

    public void setNumQues(short n) throws AppException {
        if (n <= 0) {
            throw new AppException("Num of question should be positive.");
        }
        this.numQues = n;
    }

    public short getNumQues() {
        return this.numQues;
    }

    public void setOpList(String op) throws AppException {
        OperatorList opList = new OperatorList(op);
        this.opList = opList;
    }

    public String getOpList() {
        return this.opList.toString();
    }

    public Stats getStats() {
        return this.stats;
    }
}
