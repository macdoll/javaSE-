package io;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/7 13:30
 * @return
 */
public class stuFile {
//    File类常用方法
    @Test
    public void testFileClass(){
        File file = new File("d:\\java\\test.txt");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getParent());
        System.out.println(file.getParentFile());
        System.out.println(file.exists());
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.exists());
        long len = file.length();
        System.out.println(len);
        String[] names = file.list();
        System.out.println(names);
    }
//    字符输出流
    @Test
    public void testFileWriter() throws IOException {
        File file = new File("d:\\java\\writer.txt");
        FileWriter fw = new FileWriter(file,true);
        fw.write('h');
        fw.flush();
        String s = "good good study";
        char[] data = s.toCharArray();
        fw.write(data);
        fw.flush();
        fw.close();
    }

//    字符输入流
    @Test
    public void testCharacterReader() throws IOException {
        File file = new File("d:\\java\\test1.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
        bw.write("shijie");
        bw.newLine();
        bw.write("newshijie");
        bw.newLine();
        bw.write("newnewshijie");
        bw.flush();
        bw.close();
    }

//    FileReader
    @Test
    public void testFileReader() throws IOException {
        File file = new File("d:\\java\\test1.txt");
        FileReader reader = new FileReader(file);
//        int i = reader.read();
//        System.out.println(i);
        char[] chars = new char[(int)file.length()];
        reader.read(chars);
        String s = new String(chars);
        System.out.println(s);
        reader.close();
    }

//    BufferedReader
    @Test
    public void testBufferedReader() throws IOException {
        File file = new File("d:\\java\\test1.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s;
        while((s=br.readLine())!=null){
            System.out.println(s);
        }
    }
//文件输出流
    @Test
    public void fileOutput() throws IOException {
        File file = new File("d:\\java\\test1.txt");
        if ((file.exists())==false){
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(file);
        fos.write('z');
        fos.close();
    }

//
    @Test
    public void testFileOutputArr() throws IOException {
        File file = new File("d:\\java\\test1.txt");
        if (file.exists()==false){
            file.createNewFile();
        }
        String s = "good good study";
        byte[] data = s.getBytes();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data);
        fos.close();
    }

    @Test
    public void testFileOutputStreamLength() throws IOException {
        File file = new File("d:\\java\\test1.txt");
        if (file.exists()==false){
            file.createNewFile();
        }
        String s = "wahahha";
        byte[] data = s.getBytes();
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(data,0,(int)data.length/2);
        fos.close();
    }

//    输入流
    @Test
    public void testFileInputStream() throws IOException {
        File file = new File("d:\\java\\test1.txt");
        if (file.exists()==false){
            file.createNewFile();
        }
        FileInputStream fis = new FileInputStream(file);
        int i;
//        while((i=fis.read())!=-1){
//            char c = (char)i;
//            System.out.println(c);
//        }
        while(true){
            i=fis.read();
            if (i==-1){
                break;
            }
            char c= (char)i;
            System.out.println(c);
        }
        fis.close();
    }

//    一次读取一个字节固定长度的数组
    @Test
    public void testFileInputStreamArr() throws IOException {
        File file = new File("d:\\java\\test1.txt");
        if (file.exists()==false){
            file.createNewFile();
        }
        FileInputStream fis = new FileInputStream(file);
        byte[] data = new byte[1024];
        int i;
        int length;
        while((length=fis.read(data))!=-1){
            fis.read(data,0,length);
            String s = new String(data);
            System.out.println(s);
        }
        fis.close();
    }

//    testCopy
    @Test
    public void testCopy() throws IOException {
        File oldFile = new File("d:\\java\\test1.txt");
        File newFile = new File("d:\\java\\test1Copy.txt");
        if (newFile.exists()==false){
            newFile.createNewFile();
        }
        FileInputStream fis = new FileInputStream(oldFile);
        FileOutputStream fos = new FileOutputStream(newFile);
        byte[] data = new byte[1024];
        int length;
        while((length=fis.read(data))!=-1){
            fos.write(data,0,length);
        }
        fis.close();
        fos.close();
    }
}
