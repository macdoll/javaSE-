package net;

import java.io.*;
import java.net.Socket;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/8 11:22
 * @return
 */
public class ServerThread extends  Thread{
    private Socket socket;

    public ServerThread(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String order = br.readLine();
            System.out.println("你好，客户端，这里是服务器，我收到了你的消息，消息是:"+order);
            socket.shutdownInput();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write("服务器开始响应客户端了~~~~~~~~~~~~~~~~~~");
            bw.flush();
            bw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
