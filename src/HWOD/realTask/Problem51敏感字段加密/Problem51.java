package HWOD.realTask.Problem51敏感字段加密;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = Integer.parseInt(sc.nextLine());
        String commands = sc.nextLine();

        Pattern compile = Pattern.compile("(\"[^\"]*\"|[^_]+)");
        Matcher matcher = compile.matcher(commands);

        ArrayList<String> commandList = new ArrayList<>();

        while (matcher.find()) {
            commandList.add(matcher.group());
        }

        if (K < 0 || K >= commandList.size()) {
            System.out.println("ERROR");
            return;
        }

        commandList.set(K, "******");
        System.out.println(String.join("_", commandList));
    }
}
