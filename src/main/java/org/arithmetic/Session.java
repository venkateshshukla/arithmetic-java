package org.arithmetic;

import java.lang.String;

import org.arithmetic.exception.AppException;

import org.arithmetic.OperatorList;
import org.arithmetic.PenaltyMap;
import org.arithmetic.Stats;

public class Session {

    int maxRange;
    int numQues;
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

    public void setNumQues(int n) throws AppException {
        if (n <= 0) {
            throw new AppException("Num of question should be positive.");
        }
        this.numQues = n;
    }

    public int getNumQues() {
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
