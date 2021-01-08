package com.zxg.multiThread;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/8 11:03
 * @return
 */
public class TicketThreadClassTwo implements Runnable{
    private static int ticket=100;
    public void run() {
        while (true){
            if (ticket<1){
                System.out.println("卖完了");
                break;
            }
            System.out.println(Thread.currentThread().getName()+"卖出一张，还剩余"+(--ticket));
        }
    }
}
