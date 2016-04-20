package in.vshukla.arithmetic;

import com.sun.org.apache.xpath.internal.Arg;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import in.vshukla.arithmetic.exception.InvalidOperatorException;
import in.vshukla.arithmetic.exception.InvalidValueException;

import static org.testng.Assert.*;

/**
 * Created by venkatesh on 18/4/16.
 */
public class ArgumentsTest {

    @InjectMocks
    private Arguments arguments;

    @BeforeClass
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetRangeZero() {
        int range = 0;
        arguments.setRange(range);
        Assert.assertEquals(range, arguments.getRange());
    }

    @Test
    public void testSetRangePositive() {
        int range = 9;
        arguments.setRange(range);
        Assert.assertEquals(range, arguments.getRange());
    }

    @Test
    public void testSetRangeNegative() {
        int range = -9;
        arguments.setRange(range);
        Assert.assertEquals(range, arguments.getRange());
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetRangeStringNull() throws InvalidValueException {
        String range = null;
        arguments.setRange(range);
        Assert.assertEquals(range, arguments.getRange());
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetRangeStringEmpty() throws InvalidValueException {
        String range = "";
        arguments.setRange(range);
        Assert.assertEquals(range, arguments.getRange());
    }

    @Test
    public void testSetRangeStringZero() throws InvalidValueException {
        String range = "0";
        int expRange = 0;
        arguments.setRange(range);
        Assert.assertEquals(expRange, arguments.getRange());
    }

    @Test
    public void testSetRangeStringPositive() throws InvalidValueException {
        String range = "9";
        int expRange = 9;
        arguments.setRange(range);
        Assert.assertTrue(expRange == arguments.getRange());
    }

    @Test
    public void testSetRangeStringNegative() throws InvalidValueException {
        String range = "-9";
        int expRange = -9;
        arguments.setRange(range);
        Assert.assertEquals(expRange, arguments.getRange());
    }

    @Test
    public void testSetRangeStringSpacePadded() throws InvalidValueException {
        String range = "  9  ";
        int expRange = 9;
        arguments.setRange(range);
        Assert.assertEquals(expRange, arguments.getRange());
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetRangeStringNonNumeric() throws InvalidValueException {
        String range = "a.$%^ ";
        arguments.setRange(range);
        Assert.assertEquals(range, arguments.getRange());
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetRangeStringInvalid() throws InvalidValueException {
        String range = "  - 9  ";
        arguments.setRange(range);
        Assert.assertEquals(range, arguments.getRange());
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetRangeStringMaxInt() throws InvalidValueException {
        String range = "1" + Integer.MAX_VALUE;
        arguments.setRange(range);
    }

    @Test
    public void testSetNumQuestionsZero() throws InvalidValueException {
        int num = 0;
        arguments.setNumQuestions(num);
    }

    @Test
    public void testSetNumQuestionsPositive() throws InvalidValueException {
        int num = 9;
        arguments.setNumQuestions(num);
        Assert.assertEquals(num, arguments.getNumQuestions());
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetNumQuestionsNegative() throws InvalidValueException {
        int num = -9;
        arguments.setNumQuestions(num);
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetNumQuestionsStringNull() throws InvalidValueException {
        String num = null;
        arguments.setNumQuestions(num);
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetNumQuestionsEmpty() throws InvalidValueException {
        String num = "";
        arguments.setNumQuestions(num);
    }

    @Test
    public void testSetNumQuestionsStringZero() throws InvalidValueException {
        String num = "0";
        int expNum = 0;
        arguments.setNumQuestions(num);
        Assert.assertEquals(expNum, arguments.getNumQuestions());
    }

    @Test
    public void testSetNumQuestionsStringPositive() throws InvalidValueException {
        String num = "9";
        int expNum = 9;
        arguments.setNumQuestions(num);
        Assert.assertEquals(expNum, arguments.getNumQuestions());
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetNumQuestionsStringNegative() throws InvalidValueException {
        String num = "-9";
        arguments.setNumQuestions(num);
    }

    @Test
    public void testSetNumQuestionsStringSpacePadded() throws InvalidValueException {
        String num = "  9  ";
        int expNum = 9;
        arguments.setNumQuestions(num);
        Assert.assertEquals(expNum, arguments.getNumQuestions());
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetNumQuestionsStringNonNumeric() throws InvalidValueException {
        String num = "^&*(&^%. ";
        arguments.setNumQuestions(num);
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetNumQuestionsStringInvalid() throws InvalidValueException {
        String num = " 9  9 ";
        arguments.setNumQuestions(num);
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetNumQuestionsStringMaxInt() throws InvalidValueException {
        String num = "1" + Integer.MAX_VALUE;
        arguments.setNumQuestions(num);
    }

    @Test
    public void testSetOperatorStringValid() throws Exception {
        Operator[] opArray = Operator.values();
        char[] operators = new char[opArray.length];
        for (int i = 0; i < opArray.length; i++) {
            operators[i] = opArray[i].getSymbol();
        }

        List<String> opListAll = new ArrayList<>();
        for (int i = 1; i < (2 << operators.length - 1); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < operators.length; j++) {
                if ((i & (1 << j)) != 0) {
                    sb.append(operators[j]);
                }
            }
            opListAll.add(sb.toString());
        }
        for (String s : opListAll) {
            arguments.setOperatorString(s);
            Assert.assertEquals(s, arguments.getOperatorString());
        }
    }

    @Test(expectedExceptions = InvalidOperatorException.class)
    public void testSetOperatorStringInvalid() throws Exception {
        String invalidOps = "+-@^/x*";
        arguments.setOperatorString(invalidOps);
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetOperatorStringEmpty() throws Exception {
        String invalidOps = "";
        arguments.setOperatorString(invalidOps);
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetOperatorStringNull() throws Exception {
        String invalidOps = null;
        arguments.setOperatorString(invalidOps);
    }

    @Test
    public void testAddOperatorCharValid() throws Exception {
        Operator[] operators = Operator.values();
        char[] ops = new char[operators.length];
        for (int i = 0; i < operators.length; i++) {
            ops[i] = operators[i].getSymbol();
        }
        for (int i = 0; i < ops.length; i++) {
            arguments.addOperator(ops[i]);
            Assert.assertTrue(arguments.getOperatorString().contains("" + ops[i]));
        }
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testAddOperatorCharInvalid() throws Exception {
        char op = '%';
        arguments.addOperator(op);
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testAddOperatorStringNull() throws Exception {
        String op = null;
        arguments.addOperator(op);
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testAddOperatorStringEmpty() throws Exception {
        String op = "";
        arguments.addOperator(op);
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testAddOperatorStringSpace() throws Exception {
        String op = " ";
        arguments.addOperator(op);
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testAddOperatorStringLongString() throws Exception {
        String op = "ab";
        arguments.addOperator(op);
    }

    @Test
    public void testAddOperatorStringValid() throws Exception {
        Operator[] operators = Operator.values();
        char[] ops = new char[operators.length];
        for (int i = 0; i < operators.length; i++) {
            ops[i] = operators[i].getSymbol();
        }
        for (int i = 0; i < ops.length; i++) {
            arguments.addOperator("" + ops[i]);
            Assert.assertTrue(arguments.getOperatorString().contains("" + ops[i]));
        }
    }

    @Test
    public void testAddOperatorStringNullList() throws Exception {
        Arguments arguments = new Arguments();
        char op = Operator.ADD.getSymbol();
        arguments.addOperator("" + op);
        Assert.assertNotNull(arguments.getOperatorList());
        Assert.assertFalse(arguments.getOperatorList().isEmpty());
        Assert.assertTrue(arguments.getOperatorList().contains(Operator.ADD));
        Assert.assertTrue(arguments.getOperatorString().contains("" + op));
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetOperatorListNull() throws InvalidValueException {
        List<Operator> opList = null;
        arguments.setOperatorList(opList);
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testSetOperatorListEmpty() throws InvalidValueException {
        List<Operator> opList = new ArrayList<>();
        arguments.setOperatorList(opList);
    }

    @Test
    public void testSetOperatorListValid() throws InvalidValueException {
        List<Operator> opList = new ArrayList<>();
        opList.add(Operator.ADD);
        opList.add(Operator.MULTIPLY);
        arguments.setOperatorList(opList);
        Assert.assertNotNull(arguments.getOperatorList());
        Assert.assertFalse(arguments.getOperatorList().isEmpty());
        Assert.assertTrue(arguments.getOperatorList().contains(Operator.ADD));
        Assert.assertTrue(arguments.getOperatorList().contains(Operator.MULTIPLY));
    }

    @Test(expectedExceptions = InvalidValueException.class)
    public void testAddOperatorNull() throws InvalidValueException {
        Operator op = null;
        arguments.addOperator(op);
    }

    @Test
    public void testAddOperatorValid() throws InvalidValueException {
        arguments.addOperator(Operator.SUBTRACT);
        arguments.addOperator(Operator.DIVIDE);
        Assert.assertNotNull(arguments.getOperatorList());
        Assert.assertFalse(arguments.getOperatorList().isEmpty());
        Assert.assertTrue(arguments.getOperatorList().contains(Operator.SUBTRACT));
        Assert.assertTrue(arguments.getOperatorList().contains(Operator.DIVIDE));
    }

    @Test
    public void testAddOperatorValidNullList() throws InvalidValueException {
        arguments = new Arguments();
        arguments.addOperator(Operator.SUBTRACT);
        Assert.assertNotNull(arguments.getOperatorList());
        Assert.assertFalse(arguments.getOperatorList().isEmpty());
        Assert.assertTrue(arguments.getOperatorList().contains(Operator.SUBTRACT));
    }
}