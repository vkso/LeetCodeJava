package HWOD.realTask.Problem24比赛冠亚季军;

import java.util.*;

public class Problem24 {
    /**
     * 比赛的冠亚季军
     */

    static class Sport {
        int id;
        long strength;

        public Sport(int id, long strength) {
            this.id = id;
            this.strength = strength;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] strengths = Arrays.stream(sc.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();

        System.out.println(getResult(strengths));
    }

    public static String getResult(long[] strength) {

        // 声明 ans，只记录三个数组，冠军组、亚军组、季军组
        LinkedList<ArrayList<Sport>> ans = new LinkedList<>();

        // 将输入的实力值，转换成运动员集合
        ArrayList<Sport> sports = new ArrayList<>();
        for (int i = 0; i < strength.length; i++) {
            sports.add(new Sport(i, strength[i]));
        }

        // 进行第一轮比赛，构建 ans 初始化数组的状态
        promote(sports, ans);

        // 冠军组如果不是一个人，需要取出冠军组继续进行比赛
        while (ans.getFirst().size() > 1) {
            promote(ans.removeFirst(), ans);
        }

        // 冠军
        int first = ans.get(0).get(0).id;

        // 亚军
        int second = ans.get(1).get(0).id;

        // 季军
        ans.get(2).sort((a, b) ->
                a.strength != b.strength ? (b.strength - a.strength > 0 ? 1 : -1) : a.id - b.id);

        int third = ans.get(2).get(0).id;

        return first + " " + second + " " + third;
    }

    public static void promote(ArrayList<Sport> sports, LinkedList<ArrayList<Sport>> ans) {
        ArrayList<Sport> win = new ArrayList<>();
        ArrayList<Sport> fail = new ArrayList<>();

        for (int i = 1; i < sports.size(); i += 2) {
            // 序号靠后的运动员
            Sport major = sports.get(i);
            // 序号靠前的运动员
            Sport minor = sports.get(i - 1);

            if (major.strength > minor.strength) {
                win.add(major);
                fail.add(minor);
            } else {
                win.add(minor);
                fail.add(major);
            }
        }

        // 如果运动员个数是奇数个，最后一个运动员直接晋级
        if (sports.size() % 2 != 0) {
            win.add(sports.get(sports.size() - 1));
        }

        // 依次将失败、成功组添加到列表的头部
        ans.addFirst(fail);
        ans.addFirst(win);

        // 如果保留组中的数量超过 3 个，那么移除后面的组，因为这部分组已经无法竞争季军
        while (ans.size() > 3) {
            ans.removeLast();
        }
    }
}
