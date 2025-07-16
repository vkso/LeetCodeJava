package HWOD.realTask.Problem22货币单位换算;

import java.util.Scanner;

public class Problem22 {
    /**
     * 货币单位换算
     */

    /**
     * 将传入的单位转换成人民币的 fen
     * @param unit 传递的单位
     * @return 该单位对应人民币 fen 的值
     */
    public static double exChange(String unit) {
        switch (unit) {
            case "CNY":
                return 100.0;
            case "HKD":
                return 100.0 / 123 * 100;
            case "JPY":
                return 100.0 / 1825 * 100;
            case "EUR":
                return 100.0 / 14 * 100;
            case "GBP":
                return 100.0 / 12 * 100;
            case "fen":
                return 1.0;
            case "cents":
                return 100.0 / 123 * 100 / 100;
            case "sen":
                return 100.0 / 1825 * 100 / 100;
            case "eurocents":
                return 100.0 / 14 * 100 / 100;
            case "pence":
                return 100.0 / 12 * 100 / 100;
            default:
                return 0.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        double total = 0;
        StringBuilder value = new StringBuilder();
        StringBuilder unit = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();

            for (int index = 0; index < line.length(); index++) {
                char ch = line.charAt(index);
                if (Character.isDigit(ch)) {
                    value.append(ch);
                } else {
                    unit.append(ch);
                }

                if (index + 1 == line.length()
                || Character.isDigit(line.charAt(index + 1)) && unit.length() > 0) {
                    total += Integer.parseInt(value.toString()) * exChange(unit.toString());

                    value = new StringBuilder();
                    unit = new StringBuilder();
                }
            }
        }

        System.out.println((int) total);
    }
}
