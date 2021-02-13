package com.adapter;

public class Main {
    public static void main(String[] args) {
        System.out.println("类设配器模式测试：");
        Target target = new ClassAdapter();
        target.request();
    }
}
// 对象适t配器
class ObjectAdapter implements Target{
    private Adapter adapter;
    public ObjectAdapter(Adapter adapter){
        this.adapter = adapter;
    }
    public void request(){
        // 此处可以填写扩展代码
        adapter.specifiRequest();
    }
}
// --------------------------------------------------------------
// 类适配器
interface Target{
    public void request();
}

// 适配者接口
class Adapter{
    public void specifiRequest(){
        System.out.println("适配者中的业务代码被调用！");
    }
}

// 类适配器
class ClassAdapter extends Adapter implements Target{
    public void request(){
        // 此处可以填写扩展的代码
        specifiRequest();
    }
}