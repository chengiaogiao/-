package com.chenyinjie.qq;

import java.util.HashMap;
import java.util.Vector;

public class Mxiancheng {
    private static HashMap<String,Xiancheng> xians= new HashMap<>();

    public static void addxiancheng(String userId,Xiancheng x){
        xians.put(userId,x);
    }

    public static Xiancheng getXiancheng(String userId){
        return xians.get(userId);
    }
}
