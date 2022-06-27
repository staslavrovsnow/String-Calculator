import java.util.InputMismatchException;
import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите арифмитическое действие: ");
        String str = calc(in.nextLine());
        System.out.println("\"" + str + "\"");
    }
    public static String calc(String input) {
        String[] strings;
        char ds;
        if (input.contains("+") == true) {
            strings = input.split("\" \\+ \"");
            ds = '+';
        } else if (input.contains("-") == true) {
            strings = input.split("\" - \"");
            ds = '-';
        } else if (input.contains("/") == true) {
            strings = input.split("\" / ");
            ds = '/';
        } else if (input.contains("*") == true) {
            strings = input.split("\" \\* ");
            ds = '*';
        } else {
            throw new InputMismatchException();
        }
        String str1 = strings[0].replaceAll("\"", "");
        String str2 = strings[1].replaceAll("\"", "");
        if (str1.length() > 10 | str2.length() > 10) {
            throw new InputMismatchException();
        }
        input = calculated(str1, str2, ds);
        if (input.length() > 40) {
            input = input.substring(0, 40);
            input += "...";
        }
        return input;
    }
    public static String calculated (String str1, String str2, char ds) {
        String result = "";
        int num1;
        switch (ds) {
            case '+':
                result = str1.trim() + str2.trim();
                break;
            case '-':
                result = str1.replaceAll(str2, "");
                break;
            case '*':
                str1 = str1.trim();
                str2 = str2.replaceAll(" ", "");
                num1 = Integer.parseInt(str2);
                if (num1 > 10 | num1 < 1) {
                    throw new InputMismatchException();
                }
                for (int i = 0; i < num1; i++) {
                    result += str1;
                }
                break;
            case '/':
                str1 = str1.trim();
                str2 = str2.replaceAll(" ", "");
                num1 = Integer.parseInt(str2);
                if (num1 > 10 | num1 < 1) {
                    throw new InputMismatchException();
                }
                String[] ary = str1.split("");
                for (int i = 0; i < ary.length / num1; i++) {
                    result += ary[i];
                }
                break;
        }
        return result;
    }
}
