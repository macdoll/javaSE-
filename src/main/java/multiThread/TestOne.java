package multiThread;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/8 8:49
 * @return
 */
public class TestOne {
    public static void main(String[] args) {
        ThreadTypeOne t1 = new ThreadTypeOne();
        t1.start();
        for (int i=0;i<100;i++){
            System.out.println("主线程："+i);
        }
    }
}
