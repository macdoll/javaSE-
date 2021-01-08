package com.zxg.multiThread;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/8 10:53
 * @return
 */
public class TicketThreadClass extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (ticket<0){
                System.out.println("票已经卖完，退出");
                break;
            }
            System.out.println(Thread.currentThread().getName()+"卖了一张，还剩余"+(--ticket)+"张票");
        }
    }
}
