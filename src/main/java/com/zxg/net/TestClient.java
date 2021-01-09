package com.zxg.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/9 9:07
 * @return
 */
public class TestClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8801);
            //client不需要accept，而是直接建立socket，不需要server
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("复制");
            bw.flush();
            socket.shutdownOutput();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String result = br.readLine();
            System.out.println("服务端说："+result);
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
