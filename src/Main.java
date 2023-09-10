import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите выражение: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ответ: " + calc(sc.nextLine()));
        sc.close();
    }

    public static String calc(String input) {
        input = input.replace(" ", "");
        String[] num = input.split(" ");
        String move = "";


        if (input.contains("+")) {
            num = input.split("\\+");
            move = "+";
        } else if (input.contains("-")) {
            num = input.split("-");
            move = "-";
        } else if (input.contains("*")) {
            num = input.split("\\*");
            move = "*";
        } else if (input.contains("/")) {
            num = input.split("/");
            move = "/";
        }


        if (num.length < 2) {
            try {
                throw new Exception();
            } catch (Exception e) {
                return "throws Exception //т.к. строка не является математической операцией";
            }
        } else if (num.length > 2) {
            try {
                throw new Exception();
            } catch (Exception e) {
                return "trows Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)";
            }
        }


        Convert convert = new Convert();
        if (convert.roman(num[0]) == convert.roman(num[1])) {
            int a;
            int b;
            boolean rom = convert.roman(num[0]);
            if (rom) {
                a = convert.romArab(num[0]);
                b = convert.romArab(num[1]);
            } else {
                a = Integer.parseInt(num[0]);
                b = Integer.parseInt(num[1]);
            }
            if (a <= 0 || a > 10 || b <= 0 || b > 10) {
                return "Введите числа от 1 до 10";
            }
            int res;
            String resToString;
            switch (move) {
                case "+":
                    res = a + b;
                    break;
                case "-":
                    res = a - b;
                    break;
                case "*":
                    res = a * b;
                    break;
                default:
                    res = a / b;
            }
            if (res <= 0 & rom) {
                try {
                    throw new Exception();
                } catch (Exception e) {
                    return "throws Exception //т.к. в римской системе нет отрицательных чисел";
                }
            } else if (rom) {
                return convert.arabRom(res);
            } else {
                resToString = Integer.toString(res);
                return resToString;
            }
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                return "throws Exception //т.к. используются одновременно разные системы счисления";
            }
        }
    }
}