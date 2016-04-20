package in.vshukla.arithmetic;

import org.testng.Assert;
import org.testng.annotations.Test;

import in.vshukla.arithmetic.exception.InvalidOperatorException;

/**
 * Created by venkatesh on 18/4/16.
 */
public class OperatorTest {

    @Test
    public void testGetSymbol() throws Exception {
        Operator operator = Operator.ADD;
        Assert.assertNotNull(operator.getSymbol());
        Assert.assertEquals(operator.getSymbol(), Operator.ADD.getSymbol());
    }

    @Test
    public void testGetOperation() throws Exception {
        Operator operator = Operator.ADD;
        Assert.assertNotNull(operator.getOperation());
        Assert.assertFalse(operator.getOperation().isEmpty());
        Assert.assertEquals(operator.getOperation(), Operator.ADD.getOperation());
    }

    @Test(expectedExceptions = InvalidOperatorException.class)
    public void testFromStringInvalid() throws Exception {
        char op = '#';
        Operator operator = Operator.fromChar(op);
    }

    @Test
    public void testFromStringValid() throws Exception {
        Operator[] opList = Operator.values();
        char[] ops = new char[opList.length];
        for (int i = 0; i < ops.length; i++) {
            ops[i] = opList[i].getSymbol();
        }
        for (int i = 0; i < ops.length; i++) {
            Operator operator = Operator.fromChar(ops[i]);
            Assert.assertNotNull(operator);
            Assert.assertEquals(operator, opList[i]);
        }
    }
}