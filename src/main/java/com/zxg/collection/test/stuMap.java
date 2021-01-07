package com.zxg.collection.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @param
 * @author zhu_xingguo
 * @description
 * @time 2021/1/6 9:55
 * @return
 */
public class stuMap {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("car1",30);
        for (int i=0;i<20;i++){
            map.put("car"+i,i);
        }

    }
}
