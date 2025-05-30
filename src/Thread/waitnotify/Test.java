package Thread.waitnotify;

public class Test {
    public static void main(String[] args) {
        // 创建线程对象
        Cook cook = new Cook();
        Foodie foodie = new Foodie();

        cook.setName("厨师");
        foodie.setName("吃货");

        cook.start();
        foodie.start();
    }
}
