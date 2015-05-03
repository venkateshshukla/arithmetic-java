package org.arithmetic;

import java.lang.String;
import java.lang.StringBuilder;

import org.arithmetic.exception.AppException;
import org.arithmetic.defaults.Defaults;

/**
 * List of operators to be used during a session
 * The accepted operators are '+-/*'
 * The default operators are '+-'
 */
class OperatorList {

    private int opLen;
    private String opStr;

    public OperatorList() {
        this.opLen = Defaults.DEF_OPS_LEN;
        this.opStr = Defaults.DEF_OPS;
    }

    /**
     * Make an OperatorList from a list of operator symbols passed in as string
     * The accepted operators are "+-/*"
     *
     * @param   opStr   The string containing the operator symbols
     */
    public OperatorList(String opStr) throws AppException {
        if (opStr == null) {
            throw new AppException("Operator string is null.");
        }

        String s = opStr.trim();
        if (s.isEmpty()) {
            throw new AppException("Operator string is empty.");
        }

        StringBuilder sb = new StringBuilder(s);
        StringBuilder sbOps = new StringBuilder();

        int nOps = 0;
        int i = -1, j;
        char c;
        for (j = 0; j < Defaults.ALL_OPS_LEN; j++) {
            // As ALL_OPS string is used, the resultant op string will have same
            // order no matter what the input string is.
            c = Defaults.ALL_OPS.charAt(j);
            i = sb.indexOf(String.valueOf(c));
            if (i != -1) {
                nOps ++;
                sb.deleteCharAt(i);
                sbOps.append(c);
            }
        }

        String s1 = sb.toString().trim();
        /*
         * To do or not to do??
         * If s1 is not empty, then the op string contains
         * a. additional unsupported operators
         * b. repeated supported operators
         * c. other garbage values.
         * Should an exception be thrown?? Of course.
         */

        if (!s1.isEmpty()) {
            throw new AppException("Operator string has repeated/garbage chars" + s1);
        }

        /* At least one of the operators must be true. This would helpful in
         * case the above exception is removed later.
         */
        if (nOps == 0) {
            throw new AppException("Specify at least one operator");
        }

        /* If this point is reached, it is finally safe to initialise instance
         * variable
         */
        this.opStr = sbOps.toString();
        this.opLen = nOps;
    }

    /**
     * String representation of the OperatorList
     *
     * @return  String representation of OperatorList
     */
    public String toString() {
        if (this.opStr == null) {
            return null;
        } else {
            return this.opStr;
        }
        }
    }
}
