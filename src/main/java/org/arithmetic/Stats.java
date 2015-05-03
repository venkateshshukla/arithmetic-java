package org.arithmetic;

import org.arithmetic.Question;
import org.arithmetic.RawStats;
import org.arithmetic.exception.AppException;

public class Stats {
    int numRight;
    int numWrong;
    long totalTime;
    RawStats rawStats;

    public Stats() {
        this.numRight = 0;
        this.numWrong = 0;
        this.totalTime = 0;
        this.rawStats = new RawStats();
    }

    public void addWrong(Question q, long qTime, long aTime) throws AppException {
        if (qTime >= aTime) {
            throw new AppException("Answer time must be greater than Question time.");
        }
        this.numWrong ++;
        this.totalTime += (aTime - qTime);
    }

    public void addRight(Question q, long qTime, long aTime) throws AppException {
        if (qTime >= aTime) {
            throw new AppException("Answer time must be greater than Question time.");
        }
        this.numRight ++;
        this.totalTime += (aTime - qTime);
   }
}
