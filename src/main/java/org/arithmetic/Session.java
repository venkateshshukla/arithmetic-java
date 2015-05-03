package org.arithmetic;

import java.lang.String;
import java.lang.System;
import java.util.Random;
import java.util.Scanner;

import org.arithmetic.OperatorList;
import org.arithmetic.PenaltyMap;
import org.arithmetic.Question;
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

    private int randInt() {
        int r = random.nextInt(this.maxRange + 1);
        return r;
    }

    private char randOp() throws AppException {
        int r = random.nextInt(this.opList.getOpLen());
        char c = opList.getOpChar(r);
        return c;
    }

    private Question getQuestion() throws AppException {
        return new Question(randInt(), randInt(), randOp());
    }

    public void ask() throws AppException {
        String s;
        Scanner sc;
        long qTime, aTime;
        Question q;
        int uAns, rAns;

        sc = new Scanner(System.in);
        q = getQuestion();
        rAns = q.getAns();

        if (random.nextInt(2) == 0) {
            s = String.format("%s %c %d = ", q.getLop(), q.getOp(), q.getHop());
        } else {
            s = String.format("%s %c %d = ", q.getHop(), q.getOp(), q.getLop());
        }

        System.out.print(s);
        qTime = System.currentTimeMillis();
        uAns = sc.nextInt();
        while (uAns != rAns) {
            // Add this to statistics
            // Add penalty for this question
            System.out.println("What??");
            uAns = sc.nextInt();
        }
        aTime = System.currentTimeMillis();
        // Add this to statistics
        System.out.println("Correct.");
    }
}
