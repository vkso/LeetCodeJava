package HWOD.niuke;

import java.util.Scanner;

public class hj66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().trim().split(" ");
            String unknow_command = "unknown command";

            String[][] oneWordCommands = {{"reset", "reset what"}};
            String[][] twoWordCommands = {
                    {"reset board", "board fault"},
                    {"board add", "where to add"},
                    {"board delete", "no board at all"},
                    {"reboot backplane", "impossible"},
                    {"backplane abort", "install first"}
            };

            if (split.length == 0 || split.length > 2) {
                System.out.println(unknow_command);
                continue;
            }

            if (split.length == 1) {
                if (oneWordCommands[0][0].startsWith(split[0])) {
                    System.out.println(oneWordCommands[0][1]);
                } else {
                    System.out.println(unknow_command);
                }
            } else {
                int count = 0;
                String res = null;
                for (String[] twoWordCommand : twoWordCommands) {
                    String[] split1 = twoWordCommand[0].split(" ");
                    if (split1[0].startsWith(split[0])&& split1[1].startsWith(split[1])) {
                        res = twoWordCommand[1];
                        count++;
                    }
                }
                if (count != 1) {
                    System.out.println(unknow_command);
                } else {
                    System.out.println(res);
                }
            }
        }
    }
}
