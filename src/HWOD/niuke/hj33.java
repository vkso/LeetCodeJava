package HWOD.niuke;

import java.util.Scanner;

public class hj33 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();

        System.out.println(ipToLong(line1));
        System.out.println(longToIp(Long.parseLong(line2)));
    }

    // 将点分四段的 IP 转为 “无符号”长整数
    public static long ipToLong(String ip) {
        String[] parts = ip.split("\\.");
        long res = 0;
        for (int i = 0; i < 4; i++) {
            long seg = Long.parseLong(parts[i]) & 0xFFL;
            res |= (seg << (24 - 8 * i));
        }
        return res;
    }

    // 将 “无符号”长整数还原成标准点分式 IP
    public static String longToIp(long val) {
        // 每次右移 24,16,8,0 位，然后低 8 位 & 0xFF
        return String.format("%d.%d.%d.%d",
                (val >>> 24) & 0xFF,
                (val >>> 16) & 0xFF,
                (val >>>  8) & 0xFF,
                (val       ) & 0xFF
        );
    }
}
