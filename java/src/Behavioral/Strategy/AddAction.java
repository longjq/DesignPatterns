package Behavioral.Strategy;

public class AddAction implements Action{
    @Override
    public String doAction() {
        String str = "do Add";
        return str;
    }
}
