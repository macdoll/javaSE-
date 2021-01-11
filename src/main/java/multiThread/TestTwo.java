package multiThread;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/8 8:51
 * @return
 */
public class TestTwo {
    public static void main(String[] args) {
        MyThreadTwo m1 = new MyThreadTwo();
        Thread thread = new Thread(m1);
        thread.start();
        for (int i=0;i<100;i++){
            System.out.println(i);
        }
    }
}
