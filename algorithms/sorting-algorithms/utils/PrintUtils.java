package utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class PrintUtils {
    public static void printFormattedArray(Double[] numbers) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        for (Double number : numbers) {
            System.out.println(df.format(number));
        }
    }
}
