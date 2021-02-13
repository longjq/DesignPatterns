package com.singleton;
// 某个类只能生成一个实例，该类提供了一个全局访问点供外部获取该实例，其拓展是有限多例模式
public class Main {
    public static void main(String[] args) {
        LazySingleton instance = LazySingleton.getInstance();
        instance.Hello();

        Hungrysingleton instance2 = Hungrysingleton.getInstance();
        instance2.Hello();
    }
}

// 懒汉方式单例，使用时才创建对象
class LazySingleton{
    // 保证在多线程中同步
    private static volatile LazySingleton instance = null;


    // private 构造函数，避免外部被实例化
    private LazySingleton(){}

    // 单例获取对象方法
    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

    public void Hello(){
        System.out.println("Hello,懒汉方式单例");
    }
}

// 饿汉方式单例，类加载就被创建
class Hungrysingleton{
    private static final Hungrysingleton instance = new Hungrysingleton();

    private Hungrysingleton(){}

    public static Hungrysingleton getInstance(){
        return instance;
    }

    public void Hello(){
        System.out.println("Hello,饿汉单例");
    }
}