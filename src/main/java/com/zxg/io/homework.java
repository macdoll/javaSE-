package com.zxg.io;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/7 15:54
 * @return
 */
public class homework {
    @Test
    public void writeRead() throws IOException {
        String s = "duplicate remove";
        File file = new File("d:java\\my.txt");
        if (file.exists()==false){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file, true);
        byte[] data = s.getBytes();
        fos.write(data);
        fos.close();

        FileInputStream fis = new FileInputStream(file);
        byte[] dataRead = new byte[1024];
        int length;
        while((length=fis.read(dataRead))!=-1){
            String str = new String(dataRead);
            System.out.println(str);
        }
    }
}
