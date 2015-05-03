package org.arithmetic;

public class Question {
    int lop, hop;
    char op;

    public Question(int l, int h, char c) {
        if (l < h) {
            this.lop = l;
            this.hop = h;
        } else {
            this.lop = h;
            this.hop = l;
        }
        this.op = c;
    }

    public int getLop() {
        return this.lop;
    }

    public int getHop() {
        return this.hop;
    }

    public char getOp() {
        return this.op;
    }

    public int getAns() {
        return 0;
    }
}
