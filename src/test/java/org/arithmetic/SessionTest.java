package org.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.arithmetic.OperatorList;
import org.arithmetic.Session;
import org.arithmetic.defaults.Defaults;
import org.arithmetic.exception.AppException;

public class SessionTest {

    @Test(expected = AppException.class)
    public void zeroMaxRangeTest() throws AppException {
        int r = 0;
        Session s = new Session();
        s.setMaxRange(r);
    }

    @Test(expected = AppException.class)
    public void negMaxRangeTest() throws AppException {
        int r = -5;
        Session s = new Session();
        s.setMaxRange(r);
    }

    @Test
    public void posMaxRangeTest() throws AppException {
        int r = 5;
        Session s = new Session();
        s.setMaxRange(r);

        int testRes = s.getMaxRange();

        assertEquals(testRes, r);
    }

    @Test(expected = AppException.class)
    public void zeroNumQuesTest() throws AppException {
        short n = 0;
        Session s = new Session();
        s.setNumQues(n);
    }

    @Test(expected = AppException.class)
    public void negNumQuesTest() throws AppException {
        short n = -5;
        Session s = new Session();
        s.setNumQues(n);
    }

    @Test
    public void posNumQuesTest() throws AppException {
        short n = 5;
        Session s = new Session();
        s.setNumQues(n);

        short testRes = s.getNumQues();

        assertEquals(testRes, n);
    }

    @Test
    public void opListAddTest() throws AppException {
        String op = "*+-";
        Session s = new Session();
        s.setOpList(op);

        String testRes = s.getOpList();
        String expRes = "+-*";

        assertEquals(testRes, expRes);
    }

    @Test(expected = AppException.class)
    public void garbageOpListAddTest() throws AppException {
        String op = "  * 1 q+% #V-/  ";
        Session s = new Session();
        s.setOpList(op);
    }

    @Test
    public void emptyConstructorTest() throws AppException {
        Session s = new Session();

        short expNumQues = Defaults.NUM_QUES;
        int expMaxRange = Defaults.MAX_RANGE;
        String expOpStr = Defaults.DEF_OPS;

        short testNumQues = s.getNumQues();
        int testMaxRange = s.getMaxRange();
        String testOpStr = s.getOpList();

        assertEquals(expNumQues, testNumQues);
        assertEquals(expMaxRange, testMaxRange);
        assertEquals(expOpStr, testOpStr);
    }

    @Test
    public void numConstructorTest() throws AppException {
        short numQues = 500;
        Session s = new Session(numQues);

        short expNumQues = numQues;
        int expMaxRange = Defaults.MAX_RANGE;
        String expOpStr = Defaults.DEF_OPS;

        short testNumQues = s.getNumQues();
        int testMaxRange = s.getMaxRange();
        String testOpStr = s.getOpList();

        assertEquals(expNumQues, testNumQues);
        assertEquals(expMaxRange, testMaxRange);
        assertEquals(expOpStr, testOpStr);
    }

    @Test
    public void rangeConstructorTest() throws AppException {
        int maxRange = 500;
        Session s = new Session(maxRange);

        short expNumQues = Defaults.NUM_QUES;
        int expMaxRange = maxRange;
        String expOpStr = Defaults.DEF_OPS;

        short testNumQues = s.getNumQues();
        int testMaxRange = s.getMaxRange();
        String testOpStr = s.getOpList();

        assertEquals(expNumQues, testNumQues);
        assertEquals(expMaxRange, testMaxRange);
        assertEquals(expOpStr, testOpStr);
    }

    @Test
    public void numRangeConstructorTest() throws AppException {
        short numQues = 500;
        int maxRange = 600;
        Session s = new Session(numQues, maxRange);

        short expNumQues = numQues;
        int expMaxRange = maxRange;
        String expOpStr = Defaults.DEF_OPS;

        short testNumQues = s.getNumQues();
        int testMaxRange = s.getMaxRange();
        String testOpStr = s.getOpList();

        assertEquals(expNumQues, testNumQues);
        assertEquals(expMaxRange, testMaxRange);
        assertEquals(expOpStr, testOpStr);
    }

    @Test
    public void rangeNumConstructorTest() throws AppException {
        short numQues = 500;
        int maxRange = 600;
        Session s = new Session(maxRange, numQues);

        short expNumQues = numQues;
        int expMaxRange = maxRange;
        String expOpStr = Defaults.DEF_OPS;

        short testNumQues = s.getNumQues();
        int testMaxRange = s.getMaxRange();
        String testOpStr = s.getOpList();

        assertEquals(expNumQues, testNumQues);
        assertEquals(expMaxRange, testMaxRange);
        assertEquals(expOpStr, testOpStr);
    }

    @Test
    public void byteConstrTest() throws AppException {
        // A byte argument would be cast into short constructor.
        byte numQues = 56;

        Session s;
        short testQues, expQues;

        s = new Session(numQues);
        expQues = numQues;
        testQues = s.getNumQues();

        assertEquals(expQues, numQues);
    }

    @Test(expected = AppException.class)
    public void zeroRangeConstrTest() throws AppException {
        int range = 0;
        Session s = new Session(range);
    }

    @Test(expected = AppException.class)
    public void negRangeConstrTest() throws AppException {
        int range = -5;
        Session s = new Session(range);
    }

    @Test(expected = AppException.class)
    public void zeroQuesConstrTest() throws AppException {
        short numQues = 0;
        Session s = new Session(numQues);
    }

    @Test(expected = AppException.class)
    public void negQuesConstrTest() throws AppException {
        int numQues = -5;
        Session s = new Session(numQues);
    }


}
