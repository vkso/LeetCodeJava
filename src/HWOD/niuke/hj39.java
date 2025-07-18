package HWOD.niuke;

import java.util.Scanner;
import java.util.regex.Pattern;

public class hj39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mask = sc.nextLine();
        String ip1 = sc.nextLine();
        String ip2 = sc.nextLine();

        if (!(isValidIp(ip1) && isValidIp(ip2) && isValidMask(mask))) {
            System.out.println(1);
            return;
        }

        String networkIp1 = getNetworkIp(mask, ip1);
        String networkIp2 = getNetworkIp(mask, ip2);

        if (networkIp1.equals(networkIp2)) {
            System.out.println(0);
        } else {
            System.out.println(2);
        }
    }

    public static boolean isValidMask(String mask) {
        if (!isValidIp(mask)) {
            return false;
        }

        String[] split = mask.split("\\.");
        StringBuilder binarMask = new StringBuilder();

        for (String part : split) {
            StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(Integer.parseInt(part)));
            while (binaryString.length() < 8) {
                binaryString.insert(0, "0");
            }
            binarMask.append(binaryString);
        }

        int i = binarMask.indexOf("01");
        return i == -1;
    }

    public static boolean isValidIp(String ip) {
        String IP_SEG = "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)";
        Pattern compile = Pattern.compile("^(" + IP_SEG + "\\.){3}" + IP_SEG + "$");
        return compile.matcher(ip).matches();
    }

    public static String getNetworkIp(String mask, String ip) {
        String[] splitMask = mask.split("\\.");
        String[] splitIp = ip.split("\\.");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            sb.append(getAndPartResult(splitMask[i], splitIp[i])).append(".");
        }

        return sb.toString();
    }

    public static String getAndPartResult(String mask, String ip) {
        int maskInt = Integer.parseInt(mask);
        int ipInt = Integer.parseInt(ip);

        int result = 0;

        result = maskInt & ipInt;
        return Integer.toString(result);
    }
}
