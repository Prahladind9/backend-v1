package edu.prahlad.java.course2.inheritancePolymorphism;

public class TextBox extends UIControl{
    private String text = "";

    public TextBox() {
        super(true);
        System.out.println("Text Box");
    }

    public void setText(String text) {
        this.text = text;
    }

    public void clear(){
        text = "";
    }

    @Override
    public void render() {
        System.out.println("Render TextBox");
    }

    @Override
    public String toString() {
        return "TextBox{" +
                "text='" + text + '\'' +
                '}';
    }
}
