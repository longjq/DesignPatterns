package com.bridge;

public class Main {
    public static void main(String[] args) {
        Implementor imple = new ConcreteImplementorA();
        Abstraction abs = new RefinedAbstractionImpl(imple);
        abs.Operation();
    }
}

interface Implementor{
    void OperationImpl();
}

class ConcreteImplementorA implements Implementor{
    @Override
    public void OperationImpl() {
        System.out.println("具体实现（Concrete Implementor）角色被访问");
    }
}
abstract class Abstraction{
    protected Implementor imple;

    protected Abstraction(Implementor imple){
        this.imple = imple;
    }

    protected abstract void Operation();
}
class RefinedAbstractionImpl extends Abstraction {
    protected RefinedAbstractionImpl(Implementor imple) {
        super(imple);
    }

    @Override
    protected void Operation() {
        System.out.println("扩展抽象化（Refiend Abstraction）角色被访问");
        imple.OperationImpl();
    }
}
