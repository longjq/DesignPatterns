package com.factoryMethod;

public class Main {
    public static void main(String[] args) {
        Factory factory = new ConcreteFactoryA();
        Product product = factory.newProduct();
        product.show();

        Factory factory1 = new ConcreteFactoryB();
        Product product1 = factory1.newProduct();
        product1.show();
    }
}

interface Product{
    public void show();
}

class ConcreteProductA implements Product{

    @Override
    public void show() {
        System.out.println("具体商品A");
    }
}

class ConcreteProductB implements Product{

    @Override
    public void show() {
        System.out.println("具体商品B");
    }
}

interface Factory{
    public Product newProduct();
}

class ConcreteFactoryA implements Factory{

    @Override
    public Product newProduct() {
        System.out.println("具体工厂A生成商品A");
        return new ConcreteProductA();
    }
}

class ConcreteFactoryB implements Factory{

    @Override
    public Product newProduct() {
        System.out.println("具体工厂B生成商品B");
        return new ConcreteProductB();
    }
}

