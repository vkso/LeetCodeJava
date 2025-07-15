package HWOD.Problem48猜数字;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        ArrayList<String[]> inputs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split(" ");
            inputs.add(parts);
        }

        String result = null;
        int count = 0;

        for (int i = 0; i <= 9999; i++) {
            String candidata = String.format("%04d", i);
            boolean valid = true;

            for (String[] input : inputs) {
                String guess = input[0];
                String hint = input[1];

                if (!getHint(candidata, guess).equals(hint)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                count++;
                if (count > 1) break;
                result = candidata;
            }
        }

        System.out.println(count == 1 ? result : "NA");
    }

    static String getHint(String secret, String guess) {
        int A = 0, B = 0;
        int[] countSecret = new int[10];
        int[] countGuess = new int[10];

        for (int i = 0; i < 4; i++) {
            char sc = secret.charAt(i);
            char gc = guess.charAt(i);

            if (sc == gc) {
                A++;
            } else {
                countSecret[sc - '0']++;
                countGuess[gc - '0']++;
            }
        }

        for (int d = 0; d < 10; d++) {
            B += Math.min(countSecret[d], countGuess[d]);
        }

        return A + "A" + B + "B";
    }
}
