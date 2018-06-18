package Behavioral.Strategy;

public class Test {
    public static void main(String[] args){
        Context ctx = new Context(new AddAction());
        System.out.println(ctx.doAction());

        Context ctx2 = new Context(new MulAction());
        System.out.println(ctx2.doAction());

    }
}
