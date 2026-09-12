package com.chenyinjie.file;

import java.io.*;
import java.util.Properties;

public class Home03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        Properties properties1 = new Properties();
        properties.setProperty("name","tom");
        properties.setProperty("age","5");
        properties.setProperty("color","red");
        properties.store(new FileWriter("src\\dog.properties"),null);

        properties1.load(new FileReader("src\\dog.properties"));
        Dog dog = new Dog((String) properties1.get("name"),(int)Integer.parseInt((String)properties1.get("age")),(String)properties1.get("color"));
        System.out.println(dog);

        ObjectOutputStream objectoutStream = new ObjectOutputStream(new FileOutputStream("src\\dog.dat"));
        objectoutStream.writeObject(dog);
        objectoutStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src\\dog.dat"));
        System.out.println((Dog)objectInputStream.readObject());
    }
}

class Dog implements Serializable {
    private String name;
    private  int age;
    private  String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}