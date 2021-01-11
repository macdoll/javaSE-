package jdbc.core;

import java.util.Scanner;

public class PreparedStatementUpdate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入学员编号");
        Integer id = scan.nextInt();
        System.out.println("请输入新学员名字");
        String name = scan.next();
        System.out.println("请输入新学员生日");
        String birthday = scan.next();
        System.out.println("请输入新性别");

    }
}
