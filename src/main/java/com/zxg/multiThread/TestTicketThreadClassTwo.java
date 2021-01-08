package com.zxg.multiThread;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/8 11:05
 * @return
 */
public class TestTicketThreadClassTwo {
    public static void main(String[] args) {
        TicketThreadClassTwo t1 = new TicketThreadClassTwo();
        new Thread(t1).start();
        new Thread(t1).start();
        new Thread(t1).start();
    }
}
