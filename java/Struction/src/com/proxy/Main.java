package com.proxy;

// 代理模式
// 为某对象提供一种代理以控制对该对象的访问。即客户端通过代理间接地访问该对象，从而限制、增强或修改该对象的一些特性。
public class Main {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.Request();
    }
}

interface Subject{
    void Request();
}

class RealSubject implements Subject{
    public void Request(){
        System.out.println("访问真实的主题方法");
    }
}

class Proxy extends RealSubject{
    private RealSubject realSubject;

    @Override
    public void Request() {
        if (realSubject == null){
            realSubject = new RealSubject();
        }
        preRequest();
        super.Request();
        postRequest();
    }

    public void postRequest() {
        System.out.println("访问后---》");
    }

    public void preRequest() {
        System.out.println("访问前---》");
    }
}