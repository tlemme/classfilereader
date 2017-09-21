package at.lemme.classfilereader.samples;

import java.util.Random;

public class ClassExample {
    public static final int CONSTANT_INT = 42;
    public static final long CONSTANT_LONG = 42;
    public static final double CONSTANT_DOUBLE = 42;
    public static final float CONSTANT_FLOAT = 42;

    private String s;

    public ClassExample(){

    }

    public ClassExample(String s){
        this.s = s;
    }

    public static ClassExample factoryMethod(String s){
        return new ClassExample(s);
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public void publicMethod(){
        int i =  privateMethod();
        System.out.println(i);
        ClassExample.factoryMethod("");
    }

    private int privateMethod(){
        Runnable r = ()->{
            System.out.println(123);
        };
        System.out.println(s);
        return new Random().nextInt();
    }
}
