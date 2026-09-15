package com.chenyinjie.fan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class fan01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\dog.properties"));
        Cat cat = new Cat();
        Class aClass = Class.forName(properties.getProperty("className"));
        Cat o = (Cat) aClass.newInstance();
        System.out.println(o.getClass());
        Method an = aClass.getMethod(properties.getProperty("met"));
        System.out.println(an.invoke(o));

        Field field = aClass.getField(properties.getProperty("field"));
        field.set(o,"222");
        o.aa="333";
        System.out.println(field.get(o));

        Constructor constructor = aClass.getConstructor();
        Constructor constructor1 = aClass.getConstructor(String.class);
        System.out.println(constructor);
        System.out.println(constructor1);
        Object o1 = constructor1.newInstance("111");
        System.out.println(field.get(o1));
    }
}
