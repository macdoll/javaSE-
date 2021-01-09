package com.zxg.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/9 10:21
 * @return
 */
public class ServerThreadThree extends Thread{
    private Socket socket;

    public ServerThreadThree(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            User user = (User)ois.readObject();
            String answer;
            if (user.getUserName().equals("admin")&&user.getUserPassword().equals("admin")){
                answer = "success";
            }else{
                answer = "failed";
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bw.write(answer);
            bw.flush();
            bw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
