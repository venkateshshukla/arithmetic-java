package org.arithmetic;

import java.lang.String;

import org.arithmetic.OperatorList;
import org.arithmetic.PenaltyMap;
import org.arithmetic.Stats;

public class Session {

    int maxRange;
    int numQues;
    OperatorList opList;
    Stats stats;
    PenaltyMap penMap;

    public void setMaxRange(int r) {
        if (r <= 0) {
            // Throw exception
            return;
        }
        this.maxRange = r;
    }

    public int getMaxRange() {
        return this.maxRange;
    }

    public void setNumQues(int n) {
        if (n <= 0) {
            // Throw exception
            return;
        }
        this.numQues = n;
    }

    public int getNumQues() {
        return this.numQues;
    }

    public void setOpList(String op) {
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

