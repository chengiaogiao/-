package com.chenyinjie.fan;

import java.lang.reflect.Field;

public class home01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.chenyinjie.fan.PrivateTest");
        Object o = aClass.newInstance();
        Field field = aClass.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field.get(o));

    }
}

class PrivateTest{
    private String name="hello";

    public String getName() {
        return name;
    }
}