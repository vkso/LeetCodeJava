package HWOD.realTask.Problem17注册APP;

import java.util.ArrayList;
import java.util.Scanner;

public class Problem17 {
    /**
     * APP 注册
     */
    static class App {
        String name;
        int priority;
        int startTime;  // 开始时间，分钟为单位
        int endTime;  // 结束时间，分钟为单位

        public App(String name, int priority, int startTime, int endTime) {
            this.name = name;
            this.priority = priority;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static int convertTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<App> apps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String appName = sc.next();
            int appPriority = sc.nextInt();
            int appStartTime = convertTime(sc.next());
            int appEndTime = convertTime(sc.next());
            apps.add(new App(appName, appPriority, appStartTime, appEndTime));
        }

        int queryTime = convertTime(sc.next());
        String appAtTime = "NA";

        // 创建已经注册的 App 列表
        ArrayList<App> registedApps = new ArrayList<>() ;

        for (App app : apps) {
            if (app.startTime >= app.endTime) {
                continue;
            }

            for (int i = 0; i < registedApps.size(); i++) {
                App registered = registedApps.get(i);
                // 如果时间发生冲突。时间段有重合的时候
                if (Math.max(app.startTime, registered.startTime) < Math.min(app.endTime, registered.endTime)) {
                    // 如果当前 App 的优先级高于已经注册的
                    if (app.priority > registered.priority) {
                        registedApps.remove(i);
                    } else {
                        continue;
                    }
                }
            }
            registedApps.add(app);
        }

        // 遍历注册表，找到目标时间对应的注册 App
        for (App registedApp : registedApps) {
            if (queryTime >= registedApp.startTime && queryTime < registedApp.endTime) {
                appAtTime = registedApp.name;
                break;
            }
        }

        System.out.println(appAtTime);
    }

}
























