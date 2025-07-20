package HWOD.niuke;

import java.util.Scanner;

public class hj64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt(); // 歌曲数量
        String commands = sc.next(); // 控制命令字符串
        int cursor = 1; // 当前光标位置
        int pageStart = 1; // 当前页起始歌曲编号

        for (char cmd : commands.toCharArray()) {
            if (total <= 4) {
                // 所有歌曲都能显示
                if (cmd == 'U') {
                    cursor = (cursor == 1) ? total : cursor - 1;
                } else {
                    cursor = (cursor == total) ? 1 : cursor + 1;
                }
            } else {
                // 超过4首歌，需要分页
                if (cmd == 'U') {
                    if (cursor == 1) {
                        cursor = total;
                        pageStart = total - 3;
                    } else {
                        cursor--;
                        if (cursor < pageStart) {
                            pageStart--;
                        }
                    }
                } else { // cmd == 'D'
                    if (cursor == total) {
                        cursor = 1;
                        pageStart = 1;
                    } else {
                        cursor++;
                        if (cursor > pageStart + 3) {
                            pageStart++;
                        }
                    }
                }
            }
        }

        // 打印当前页面
        if (total <= 4) {
            for (int i = 1; i <= total; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (int i = pageStart; i < pageStart + 4; i++) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        System.out.println(cursor);
    }
}
