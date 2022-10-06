package com.dv.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) {
        try {
            Constructor<Hi> constructor = Hi.class.getConstructor();
            Hi hi = constructor.newInstance();
            hi.sayHello();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Hi {
    public Hi() {
    }

    public Hi(String hello) {
        System.out.println(hello);
    }

    public void sayHello() {
        System.out.println("xin chao");
    }
}
