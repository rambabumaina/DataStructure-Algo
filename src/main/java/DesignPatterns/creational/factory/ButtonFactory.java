package DesignPatterns.creational.factory;

public class ButtonFactory {
    public static Button getInstance(String type){
        if(type.trim().equalsIgnoreCase("window")){
            return new Window();
        }else {
            return new WebPage();
        }
    }
}
