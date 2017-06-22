import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.abs;
import static java.lang.Math.cos;
import static java.lang.Math.sin;


public class Newton {

    public static String ACCURACY = "0\\.\\d{0,6}[1-9]";
    public static String SPECNUMBER = "-?\\d{1,6}(\\.\\d+)?";
    public static String NUMBER = "-?\\d+(\\.\\d+)?";
    public static double f(double x){
        return x*x-2*x-2*cos(x);
    }
    public static double df(double x){
        return 2*x-2+2*sin(x);
    }
    public static double ddf(double x){
        return 2+2*cos(x);
    }

    static double a, b, accuracy;
    static Matcher matcher;
    static Pattern pattern;

    static void method(double a, double b, double accuracy){
        double x0 = (a + b) / 2;
        int counter = 0;
        while (abs(df(x0)) > accuracy) {
            x0 = x0 - (df(x0) / ddf(x0));
            counter++;
        }
        System.out.println("\nТочка минимума - " + x0 + "\nКоличество иттераций - "
                + counter + "\n");
    }

    static void enterValues(){
        Scanner in = new Scanner(System.in);

        pattern=Pattern.compile(NUMBER);

        do {
            String input = in.next();
            matcher = pattern.matcher(input);
            if (matcher.matches()) {
                pattern = Pattern.compile(SPECNUMBER);
                matcher = pattern.matcher(input);
                if (matcher.matches())
                    a = Double.valueOf(input);
                else
                    System.out.println("Ошибка ввода. Введите число в интервале (-1000000;1000000).");
            } else
                System.out.println("Ошибка ввода. Введенная строка не является числом.");
        } while(!matcher.matches());

        pattern=Pattern.compile(NUMBER);

        do {
            String input = in.next();
            matcher = pattern.matcher(input);
            if (matcher.matches()) {
                pattern = Pattern.compile(SPECNUMBER);
                matcher = pattern.matcher(input);
                if (matcher.matches())
                    b = Double.valueOf(input);
                else
                    System.out.println("Ошибка ввода. Введите число в интервале (-1000000;1000000).");
            } else {
                System.out.println("Ошибка ввода. Введенная строка не является числом.");
            }
        } while(!matcher.matches());

        pattern = Pattern.compile(NUMBER);

        do {
            String input = in.next();
            matcher = pattern.matcher(input);
            if (matcher.matches()) {
                pattern = Pattern.compile(ACCURACY);
                matcher = pattern.matcher(input);
                if (matcher.matches())
                    accuracy = Double.valueOf(input);
                else
                    System.out.println("Ошибка ввода. Введите число в интервале (0.0000001;0.9999999).");
            } else
                System.out.println("Ошибка ввода. Введенная строка не является числом.");
        } while(!matcher.matches());

    }

    public static void main(String[] args) {
        enterValues();
        method(a,b, accuracy);
    }
}
