package org.arithmetic;

import java.lang.String;
import java.lang.StringBuilder;

import org.arithmetic.exception.AppException;
import org.arithmetic.defaults.Defaults;

/**
 * List of operators to be used during a session.
 * The accepted operators are '+-/*'
 * The default operators are '+-'
 */
class OperatorList {

    private boolean[] opList;

    public OperatorList() {
        this.opList = new boolean[Defaults.ALL_OPS_LEN];
        // By default, add and subtract are supported.
        this.opList[0] = true;  // +
        this.opList[1] = true;  // -
        this.opList[2] = false; // /
        this.opList[3] = false; // *
    }

    /**
     * Make an OperatorList from a list of operator symbols passed in as string.
     * The accepted operators are "+-/*"
     *
     * @param   opStr   The string containing the operator symbols
     */
    public OperatorList(String opStr) throws AppException {
        if (opStr == null)
            throw new AppException("Operator string is null.");

        String s = opStr.trim();
        if (s.isEmpty())
            throw new AppException("Operator string is empty.");

        StringBuilder sb = new StringBuilder(s);
        boolean[] ops = new boolean[Defaults.ALL_OPS_LEN];
        int i = -1, j;
        for (j = 0; j < Defaults.ALL_OPS_LEN; j++) {
            // get char at index j as a substring
            i = sb.indexOf(Defaults.ALL_OPS.substring(j, j + 1));
            if (i == -1) {
                ops[j] = false;
            } else {
                ops[j] = true;
                sb.deleteCharAt(i);
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
        boolean b = false;
        for (j = 0; j < Defaults.ALL_OPS_LEN; j++) {
            b = b | ops[j];
        }
        if (!b) {
            throw new AppException("Specify at least one operator");
        }

        /* If this point is reached, it is finally safe to initialise instance
         * variable
         */
        opList = new boolean[Defaults.ALL_OPS_LEN];
        for (j = 0; j < Defaults.ALL_OPS_LEN; j++) {
            this.opList[j] = ops[j];
        }
    }

    /**
     * String representation of the OperatorList
     *
     * @return  String representation of OperatorList
     */
    public String toString() {
        if (this.opList == null) {
            return null;
        }
        int i;
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < Defaults.ALL_OPS_LEN; i++) {
            if (this.opList[i]) {
                sb.append(Defaults.ALL_OPS.charAt(i));
            }
        }
        return sb.toString();
    }
}
