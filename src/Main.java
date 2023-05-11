import com.leetcode.tools.MyLinkedList;
import com.leetcode.tools.TreeNode;
import org.junit.Test;

import java.io.*;
import java.util.ArrayDeque;
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

    /**
     * 文件字节流的读与写
     */
    @Test
    public void ioTest() {
        try (FileInputStream fis = new FileInputStream("/Users/yuchen/Downloads/girl.jpg");
        FileOutputStream fos = new FileOutputStream("/Users/yuchen/Downloads/girl-copy.jpg")) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件字符流读与写
     */
    public void ioTestt() {
        try (FileReader fr = new FileReader("input.txt");
        FileWriter fw = new FileWriter("output.txt")) {
            char[] buffer = new char[1024];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void threadTest() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("test start");
            }
        });
        thread.run();
    }
}

