package com.zxg.net;

import java.io.*;
import java.net.Socket;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/9 18:06
 * @return
 */
public class TestClientTwo {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8800);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("client sned");
            bw.flush();
            socket.shutdownOutput();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = br.readLine();
            System.out.println("from server get what:"+s);
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
