package calculator;

// import math java modules
import java.math.*;

/**
 * @see Operation Class
 * 
 * @summary: declare all method fn for operatoion, that is: addition, division,
 *           substraction, multiplication, modulus. Each method function must
 *           return value after calculation. every method fn have a array double
 *           parameter from Features class.
 * 
 */

public class Operation {

    public static double useAdd(double[] arrayNum) {
        BigDecimal number1 = new BigDecimal(Double.toString(arrayNum[0]));
        BigDecimal number2 = new BigDecimal(Double.toString(arrayNum[1]));
        return number1.add(number2).doubleValue();
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
    }

}
