package org.arithmetic;

import java.lang.String;
import java.lang.System;
import java.util.Random;

import org.arithmetic.OperatorList;
import org.arithmetic.PenaltyMap;
import org.arithmetic.Stats;
import org.arithmetic.exception.AppException;
import org.arithmetic.defaults.Defaults;

public class Session {

    short numQues;
    int maxRange;
    OperatorList opList;
    Stats stats;
    PenaltyMap penMap;
    Random random;

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

    public void setOpList() throws AppException {
        OperatorList opList = new OperatorList();
        this.opList = opList;
    }

    public String getOpList() {
        return this.opList.toString();
    }

    public Stats getStats() {
        return this.stats;
    }

    public Session(short numQues, int maxRange) throws AppException {
        setMaxRange(maxRange);
        setNumQues(numQues);
        setOpList();
        this.stats = new Stats();
        this.penMap = new PenaltyMap();
        this.random = new Random(System.currentTimeMillis());
    }

    public Session(int maxRange, short numQues) throws AppException {
        this(numQues, maxRange);
    }

    public Session(int maxRange) throws AppException {
        this(Defaults.NUM_QUES, maxRange);
    }

    public Session(short numQues) throws AppException {
        this(numQues, Defaults.MAX_RANGE);
    }

    public Session() throws AppException {
        this(Defaults.NUM_QUES, Defaults.MAX_RANGE);
    }
}
