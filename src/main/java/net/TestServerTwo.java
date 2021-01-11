package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/9 17:59
 * @return
 */
public class TestServerTwo {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8800);
            while(true){
                Socket socket = ss.accept();
                ServerThreadThree st = new ServerThreadThree(socket);
                st.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
