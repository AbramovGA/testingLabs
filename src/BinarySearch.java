import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinarySearch {

    static String AMOUNT = "\\d{1,4}";
    static String NUMBER = "-?\\d+(\\.\\d+)?";
    static String KEYCHECK = "\\d{1,3}";
    static Matcher matcher;
    static Pattern pattern;
    static int[] a;
    static int n;
    static int key;


    static int search(){
        int left=-1;
        int right=n;
        while(left<right-1){
            int mid=(left+right)/2;
            if(a[mid]<key){
                left=mid;
            } else{
                right=mid;
            }
        }
        if(a[right]!=key) {
            System.out.println("Искомое число не содержится в массиве.");
            return -1;
        }
        return right;
    }


    static void enterValues(){
        a=new int[10000];

        Scanner in = new Scanner(System.in);

        pattern= Pattern.compile(NUMBER);

        do {
            String input = in.next();
            matcher = pattern.matcher(input);
            if (matcher.matches()) {
                pattern = Pattern.compile(AMOUNT);
                matcher = pattern.matcher(input);
                if (matcher.matches())
                    n = Integer.valueOf(input);
                else
                    System.out.println("Ошибка ввода. Введите число в диапазоне [1;9999].");
            } else
                System.out.println("Ошибка ввода. Введенная строка не является числом.");
        } while(!matcher.matches());


        int i=0;

        while(i<n) {
            pattern = Pattern.compile(NUMBER);

            do {
                String input = in.next();
                matcher = pattern.matcher(input);
                if (matcher.matches()) {
                    pattern = Pattern.compile(KEYCHECK);
                    matcher = pattern.matcher(input);
                    if (matcher.matches())
                        if(i>0)
                            if(Integer.valueOf(input)>=a[i-1])
                                a[i] = Integer.valueOf(input);
                            else
                                System.out.println("Ошибка ввода. Введите элемент больший, либо равный предыдущему.");
                        else
                            a[i] = Integer.valueOf(input);
                    else
                        System.out.println("Ошибка ввода. Введите число в диапазоне [1;999].");
                } else {
                    System.out.println("Ошибка ввода. Введенная строка не является числом.");
                }
            } while (!matcher.matches());

            i++;
        }

        pattern = Pattern.compile(NUMBER);

        do {
            String input = in.next();
            matcher = pattern.matcher(input);
            if (matcher.matches()) {
                pattern = Pattern.compile(KEYCHECK);
                matcher = pattern.matcher(input);
                if (matcher.matches())
                    key = Integer.valueOf(input);
                else
                    System.out.println("Ошибка ввода. Введите число в диапазоне [1;999].");
            } else
                System.out.println("Ошибка ввода. Введенная строка не является числом.");
        } while(!matcher.matches());

    }


    public static void main(String[] args) {

        enterValues();
        int res=search();
        if(res!=-1)
            System.out.println("Позиция элемента в массиве - res");
    }
}

