import com.leetcode.tools.MyLinkedList;
import com.leetcode.tools.TreeNode;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");
        FileInputStream fileInputStream = new FileInputStream("/Users/yuchen/Downloads/guanlan.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));

        String regStr = "<a href=\"(magnet:\\?xt=urn:btih:\\w+)\"";
        Pattern pattern = Pattern.compile(regStr);

        String str = null;
        while ((str = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {

                System.out.println(matcher.group(1));
            }
        }

        fileInputStream.close();
        br.close();
    }
}

