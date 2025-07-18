package HWOD.niuke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class hj19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> res = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split(" ");
            String filePath = split[0];
            String lineNumber = split[1];

            String[] split1 = filePath.split("\\\\");
            String fileName = split1[split1.length - 1];

            if (fileName.length() >= 16) {
                fileName = fileName.substring(fileName.length() - 16);
            }

            String errorMsg = fileName + " " + lineNumber;

            if (!map.containsKey(errorMsg)) {
                map.put(errorMsg, 1);
                res.add(errorMsg);
            } else {
                map.put(errorMsg, map.get(errorMsg) + 1);
            }
        }

        for (int i = Math.max(0, res.size() - 8); i < res.size(); i++) {
            String msg = res.get(i);
            System.out.println(msg + " " + map.get(msg));
        }
    }
}
