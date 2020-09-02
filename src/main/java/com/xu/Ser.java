package com.xu;

import java.io.*;

public class Ser {
    public static void main(String[] args) throws Exception {
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
//                new File("F:\\lanxinDownload\\pp")));
//        Object person =  ois.readObject();
//
//        System.out.println("对象反序列化成功！");
        parse();
    }


    public static void parse()  throws Exception{
        Person person = new Person();
        person.name="gacl";
        /** ObjectOutputStream 对象输出流，将Person对象存储到E盘的Person.txt文件中，完成对Person对象的序列化操作 **/
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("E:/Person.txt")));
        oo.writeObject(person);
        System.out.println("Person对象序列化成功！");
        oo.close();
    }

}

class Person implements Serializable{
    public  String name;
}
