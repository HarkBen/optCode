package com.opt.libb.reflection;

public class JavaMessage {
    String name = "JavaMessage";
    int age = 1;

    @Override
    public String toString() {

        return "JavaMessage fields:"+ JavaMessage.class.getDeclaredFields().length;
    }
}
