package com.absFactoryMethod;

public class Main {
    public static void main(String[] args) {
        AbsFactory factory = new ConcreteFactory1();
        Product product = factory.newProduct1();
        product.show();

        Product product1 = factory.newProduct2();
        product1.show();
    }
}

interface Product{
    void show();
}

class Product1 implements Product{

    @Override
    public void show() {
        System.out.println("商品1");
    }
}
class Product2 implements Product{

    @Override
    public void show() {
        System.out.println("商品2");
    }
}

interface AbsFactory{
    Product1 newProduct1();
    Product2 newProduct2();
}

class ConcreteFactory1 implements AbsFactory{

    @Override
    public Product1 newProduct1() {
        System.out.println("具体工厂1生产商品1");
        return new Product1();
    }

    @Override
    public Product2 newProduct2() {
        System.out.println("具体工厂1生产商品2");
        return new Product2();
    }
}

class ConcreteFactory2 implements AbsFactory{

    @Override
    public Product1 newProduct1() {
        System.out.println("具体工厂2生产商品1");
        return new Product1();
    }

    @Override
    public Product2 newProduct2() {
        System.out.println("具体工厂2生产商品2");
        return new Product2();
    }
}