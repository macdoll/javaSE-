package multiThread;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/8 8:48
 * @return
 */
public class MyThreadTwo implements Runnable{
    public void run() {
        for (int i =0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
