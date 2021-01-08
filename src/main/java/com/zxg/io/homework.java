package com.zxg.io;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/7 15:54
 * @return
 */
public class homework {
    /**
     * 1、使用对象流将一个程序中创建的对象写入TXT文件，
     * 再对象读取到程序中，打印对象
     * win下的路径d:\\java\\test.txt
     * @throws IOException
     */
    @Test
    public void writeRead() throws IOException {
        String s = "duplicate remove";
        File file = new File("d:\\java\\my.txt");
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

    /**
     * 2、（字符流+缓冲流）读取一个文本文件，
     * 每行都追加一个“好”，在文件结尾再追加“完毕”。
     *
     * 总结：又想读，又想写，应该先读后写，读的结果保存起来
     * iter.next可以在类型转换的同时保存到新的变量，可以长期使用
     * 换行符有用，在集合里存起来也有用
     */
    @Test
    public void readAndAdd() throws IOException {
        File file = new File("d:\\java\\my.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> arr = new ArrayList<String>();
        String b;
        while ((b=br.readLine())!=null){
            String tmpStr = b+"好\n";
            arr.add(tmpStr);
        }
        arr.add("结束");
        br.close();
        System.out.println(arr);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        Iterator iter = arr.iterator();
        while (iter.hasNext()){
            String s = (String)iter.next();
            bw.write(s);
        }
        bw.flush();
        bw.close();
    }


    /**
     * 2、分别使用节点流：FileInputStream、FileOutputStream和缓冲流：
     * BufferedInputStream、BufferedOutputStream实现文本文件/图片/视频文件的复制。
     * 并比较二者在数据复制方面的效率
     *
     * java如何计算程序运行的时间
     */
    @Test
    public void compareCopySpeedFos() throws IOException {
        long startTime = System.currentTimeMillis();
        File file = new File("d:\\java\\1.mp4");
        File fileWrite = new File("d:\\java\\new\\1.mp4");
        if (fileWrite.exists()==false){
            fileWrite.createNewFile();
        }
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileWrite);
//        byte[] data = new byte[1024];
        int length;
        while ((length=fis.read())!=-1){
            fos.write(length);
        }
        fos.flush();
        fis.close();
        fos.close();
        long endTime = System.currentTimeMillis();
        System.out.println("costTime:"+(endTime-startTime)+"ms");

    }

    @Test
    public void compareCopySpeedBuffer() throws IOException {
        long startTime = System.currentTimeMillis();
        File oldFile = new File("d:\\java\\1.mp4");
        File newFile = new File("d:\\java\\new\\buffer.mp4");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(oldFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newFile));
        int readContent;
        while ((readContent=bis.read())!=-1){
            bos.write(readContent);
        }
        bos.close();
        bis.close();
        long endTime  = System.currentTimeMillis();
        System.out.println("costTime:"+(endTime-startTime)+"ms");
    }
    //结论：fileInputStream是比较慢的，但是使用数组缓冲可以快快加速，
    //一般认为，BufferedInputStream还是比fileInputStream快的
}
