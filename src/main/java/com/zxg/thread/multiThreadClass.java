package com.zxg.thread;

public class multiThreadClass extends Thread {
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            System.out.println(this.getName()+"多线程的run方法");
        }
    }
}
