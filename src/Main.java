import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Input:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(calc(s));
    }

    public static String calc(String s) throws Exception {
        String s1 = s.replaceAll("\\s+", "");
        int a;
        int b;
        String oper;
        String res;
        boolean isRim;

        String[] operandc = s1.split("[+\\-*/]");

        if (operandc.length != 2)
            throw new Exception("- должно быть 2 операнда");


        oper = scanOper(s1);

        if (operandc == null)
            throw new Exception("- два операнда и 1 оператор (+, -, *, /");

        if (ConverterRim.isRim(operandc[0]) && ConverterRim.isRim(operandc[1])) {
            a = ConverterRim.convertArab(operandc[0]);
            b = ConverterRim.convertArab(operandc[1]);
            isRim = true;
        } else if (!ConverterRim.isRim(operandc[0]) && !ConverterRim.isRim(operandc[1])) {
            a = Integer.parseInt(operandc[0]);
            b = Integer.parseInt(operandc[1]);
            isRim = false;
        } else {
            throw new Exception("- так как используется одновременно разные системы счисления");
        }


        int arab = matDeistvie(a, b, oper);
        if (isRim) {
            if (arab <= 0) {
                throw new Exception("- В римских числах нет отрицательных чисел ");
            }
            res = ConverterRim.convertRim(arab);
        } else {
            res = String.valueOf(arab);
        }
        return res;
    }
    class ConverterRim {

        static String[] yesRim = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        public static boolean isRim(String r) {
            for (int i = 0; i < yesRim.length; i++) {
                if (r.equals(yesRim[i])) {
                    return true;
                }
            }
            return false;

        }
        public static int convertArab (String r){
            for (int i = 0; i < yesRim.length; i++) {
                if (r.equals(yesRim[i])) {
                    return i;

                }
            }
            return -1;
        }

        public static String convertRim ( int arab){

            return yesRim[arab];
        }
    }

    static String scanOper(String s1) {   // Проверка знака
        if (s1.contains("+")) {
            return "+";
        } else if (s1.contains("-")) {
            return "-";
        } else if (s1.contains("*")) {
            return "-";
        } else if (s1.contains("/")) {
            return "/";
        } else {
            return null;
        }
    }

    static int matDeistvie(int a, int b, String oper) {
        if (oper.equals("+")) {      //математические действия
            return a + b;
        } else if (oper.equals("-")) {
            return a - b;
        } else if (oper.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }
}