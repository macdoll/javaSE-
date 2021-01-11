package thread;

public class testMultiThreadClass {
    public static void main(String[] args) {
        System.out.println("主线程的方法");
        multiThreadClass m1 = new multiThreadClass();
        multiThreadClass m2 = new multiThreadClass();
        multiThreadClass m3 = new multiThreadClass();
        multiThreadClass m4 = new multiThreadClass();
        m1.start();
        m2.start();
        m3.start();
        m4.start();


    }
}
