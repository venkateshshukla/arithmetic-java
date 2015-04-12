package org.arithmetic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.arithmetic.OperatorList;
import org.arithmetic.exception.AppException;

public class OperatorListTest {

    @Test
    public void noStringTest() {
        OperatorList opList = new OperatorList();

        String testRes = opList.toString();
        String expRes = "+-";

        assertEquals(testRes, expRes);
    }

    @Test(expected = AppException.class)
    public void nullStringTest() throws AppException {
        OperatorList opList = new OperatorList(null);
    }

    @Test(expected = AppException.class)
    public void emptyStringTest() throws AppException {
        OperatorList opList = new OperatorList("");
    }

    @Test
    public void allOpStringTest() throws AppException {
        String opStr, testRes, expRes;
        OperatorList opList;

        // All the operators
        opStr = "-+*/";
        opList = new OperatorList(opStr);
        testRes = opList.toString();
        expRes = "+-/*";
        assertEquals(testRes, expRes);
    }

    @Test
    public void someOpStringTest() throws AppException {
        String opStr, testRes, expRes;
        OperatorList opList;

        // Partial operators
        opStr = "-";
        opList = new OperatorList(opStr);
        testRes = opList.toString();
        expRes = "-";
        assertEquals(testRes, expRes);

        opStr = "/";
        opList = new OperatorList(opStr);
        testRes = opList.toString();
        expRes = "/";
        assertEquals(testRes, expRes);

        opStr = "*+";
        opList = new OperatorList(opStr);
        testRes = opList.toString();
        expRes = "+*";
        assertEquals(testRes, expRes);

        opStr = "/*-";
        opList = new OperatorList(opStr);
        testRes = opList.toString();
        expRes = "-/*";
        assertEquals(testRes, expRes);
    }

    @Test(expected = AppException.class)
    public void spaceOpStringTest0() throws AppException {
        String opStr = "   ";
        OperatorList opList = new OperatorList(opStr);
    }

    @Test
    public void spaceOpStringTest1() throws AppException {
        String opStr, testRes, expRes;
        OperatorList opList;

        opStr = "  /+*  ";
        opList = new OperatorList(opStr);
        testRes = opList.toString();
        expRes = "+/*";

        assertEquals(testRes, expRes);
    }

    @Test
    public void spaceOpStringTest2() throws AppException {
        String opStr, testRes, expRes;
        OperatorList opList;

        opStr = "  / + - *  ";
        opList = new OperatorList(opStr);
        testRes = opList.toString();
        expRes = "+-/*";

        assertEquals(testRes, expRes);
    }

    @Test(expected = AppException.class)
    public void repeatedOpStringTest0() throws AppException {
        String opStr = "++";
        OperatorList opList = new OperatorList(opStr);
    }

    @Test(expected = AppException.class)
    public void repeatedOpStringTest1() throws AppException {
        String opStr = "+-/*+-*";
        OperatorList opList = new OperatorList(opStr);
    }

    @Test(expected = AppException.class)
    public void garbageOpStringTest0() throws AppException {
        String opStr = ">a";
        OperatorList opList = new OperatorList(opStr);
    }

    @Test(expected = AppException.class)
    public void garbageOpStringTest1() throws AppException {
        String opStr = "-a+";
        OperatorList opList = new OperatorList(opStr);
    }

    @Test(expected = AppException.class)
    public void garbageOpStringTest2() throws AppException {
        String opStr = "+>2/-a*..1";
        OperatorList opList = new OperatorList(opStr);
    }
}
