package com.builder;

public class Main {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }
}

// 商品类
class Product{
    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    private String partA;
    private String partB;
    private String partC;

    public void show(){
        System.out.println(this.partA);
        System.out.println(this.partB);
        System.out.println(this.partC);
        System.out.println("产品的特性");
    }
}

// 抽象构建者，只负责明确的部分，不明确部分，使用抽象方法代替
abstract class Builder{
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getResult(){
        return product;
    }
}

// 具体创建者，实现抽象的建造部分
class ConcreteBuilder extends Builder{

    @Override
    public void buildPartA() {
        product.setPartA("建造A部分");
    }

    @Override
    public void buildPartB() {
        product.setPartB("建造B部分");
    }

    @Override
    public void buildPartC() {
        product.setPartC("建造C部分");
    }
}

// 指挥类，在该类中重组抽象和具体的聚合
class Director {
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }

    public Product construct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}


