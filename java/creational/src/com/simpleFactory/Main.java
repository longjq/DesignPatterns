package com.simpleFactory;

public class Main {
    public static void main(String[] args) {
        Product a = SimpleFactory.create(1);
        a.show();

        Product b = SimpleFactory.create(2);
        b.show();

    }
}

interface Product{
    void show();
}

class ProductA implements Product {

    @Override
    public void show() {
        System.out.println("商品A");
    }
}

class ProductB implements Product{

    @Override
    public void show() {
        System.out.println("商品B");
    }
}

class SimpleFactory{
    public static Product create(int id){
        switch (id){
            case 1:
                return new ProductA();
            case 2:
                return new ProductB();
            default:
                System.out.println("没有命中的商品");
                return null;
        }
    }
}