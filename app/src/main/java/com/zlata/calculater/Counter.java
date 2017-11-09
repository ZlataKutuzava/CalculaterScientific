package com.zlata.calculater;

import org.mariuszgromada.math.mxparser.Expression;

public class Counter {

    private static Boolean isCalculated = false;

    public static String calculate(String expr) {
        Expression expression = new Expression(expr);
        double result = expression.calculate();
        String resultStr;

        if (result - (int) result == 0) {
            resultStr = String.valueOf((int) result);
        } else {
            resultStr = String.valueOf(result);
        }
        if (resultStr.length() >= 12) {
            resultStr = String.format("%.12s", Float.valueOf(resultStr));
        }
        if (resultStr.equals("NaN")) {
            resultStr = "Error";
        }
        isCalculated = true;
        return resultStr;
    }

    public static Boolean isCounted() {
        return isCalculated;
    }

    public static void resetCount() {
        isCalculated = false;
    }

}