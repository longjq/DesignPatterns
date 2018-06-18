package Behavioral.Strategy;

public class Context {
    Action action;

    public Context(Action action){
        this.action = action;
    }

    public String doAction(){
        return this.action.doAction();
    }
}
