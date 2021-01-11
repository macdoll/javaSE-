package net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/9 8:52
 * @return
 */
public class TestServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8801);
            Socket socket = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String order = br.readLine();
            System.out.println("服务器收到命令："+order);
            socket.shutdownInput();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("服务端已经响应");
            bw.flush();
            bw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
