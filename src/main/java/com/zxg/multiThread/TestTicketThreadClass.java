package com.zxg.multiThread;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/8 10:56
 * @return
 */
public class TestTicketThreadClass {
    public static void main(String[] args) {
        TicketThreadClass t1 = new TicketThreadClass();
        TicketThreadClass t2 = new TicketThreadClass();
        TicketThreadClass t3 = new TicketThreadClass();
        t1.start();
        t2.start();
        t3.start();
    }
}
