package calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Operation {

    public static double useAdd(double[] arrayNum) {
        BigDecimal number1 = new BigDecimal(Double.toString(arrayNum[0]));
        BigDecimal number2 = new BigDecimal(Double.toString(arrayNum[1]));
        return number1.add(number2).doubleValue();
        // return ((double) arrayNum[0] + (double) arrayNum[1]);
    }

    public static double useDiv(double[] arrayNum) {
        BigDecimal number1 = new BigDecimal(Double.toString(arrayNum[0]));
        BigDecimal number2 = new BigDecimal(Double.toString(arrayNum[1]));
        return number1.divide(number2, 3, RoundingMode.CEILING).doubleValue();
    }

    public static double useSubs(double[] arrayNum) {
        BigDecimal number1 = new BigDecimal(Double.toString(arrayNum[0]));
        BigDecimal number2 = new BigDecimal(Double.toString(arrayNum[1]));
        return number1.subtract(number2).doubleValue();
    }

    public static double useMulti(double[] arrayNum) {
        BigDecimal number1 = new BigDecimal(Double.toString(arrayNum[0]));
        BigDecimal number2 = new BigDecimal(Double.toString(arrayNum[1]));
        return number1.multiply(number2).doubleValue();
    }

    public static double useModulo(double[] arrayNum) {
        BigDecimal number1 = new BigDecimal(Double.toString(arrayNum[0]));
        BigDecimal number2 = new BigDecimal(Double.toString(arrayNum[1]));
        return number1.remainder(number2).doubleValue();
        // return ((double) arrayNum[0] % (double) arrayNum[1]);
    }

}
