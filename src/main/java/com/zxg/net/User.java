package com.zxg.net;

import java.io.Serializable;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/9 10:29
 * @return
 */
public class User implements Serializable {
    private String userName;
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
