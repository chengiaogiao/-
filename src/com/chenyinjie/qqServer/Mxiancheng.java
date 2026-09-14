package com.chenyinjie.qqServer;



import java.util.HashMap;
import java.util.Iterator;

public class Mxiancheng {
    private static HashMap<String, Xiancheng> xians= new HashMap<>();

    public static void addxiancheng(String userId, Xiancheng x){
        xians.put(userId,x);
    }

    public static Xiancheng getXiancheng(String userId){
        return xians.get(userId);
    }
   public  static  void reXiancheng(String userId){
//       getXiancheng(userId).
       xians.remove(userId);
   }
    public static  String getOn(){
        Iterator<String> iterator=xians.keySet().iterator();
        String c="";
        while (iterator.hasNext()) {
            c+=iterator.next().toString()+" ";
        }
        return  c;
    }
}
