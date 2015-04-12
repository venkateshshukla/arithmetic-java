package org.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.arithmetic.OperatorList;
import org.arithmetic.Session;
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
        int n = 0;
        Session s = new Session();
        s.setNumQues(n);
    }

    @Test(expected = AppException.class)
    public void negNumQuesTest() throws AppException {
        int n = -5;
        Session s = new Session();
        s.setNumQues(n);
    }

    @Test
    public void posNumQuesTest() throws AppException {
        int n = 5;
        Session s = new Session();
        s.setNumQues(n);

        int testRes = s.getNumQues();

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

}
