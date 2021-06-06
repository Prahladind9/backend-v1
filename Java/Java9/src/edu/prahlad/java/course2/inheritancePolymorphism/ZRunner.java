package edu.prahlad.java.course2.inheritancePolymorphism;

public class ZRunner {
    public static void main(String[] args) {
        var point1 = new Point(1, 2);
        var point2 = new Point(1, 2);
        System.out.println("compareObjects: " + point1.equals(point2));

//        var uiControlBase = new UIControl(true);
//        System.out.println(uiControlBase.isEnabled());

        var textBox = new TextBox();
        System.out.println(textBox.isEnabled());
        System.out.println(textBox.hashCode()); //hashCode of the address of the object, stored in the memory
        textBox.setText("Hello World");
        System.out.println(textBox);

        //showDownCast(new UIControl());//ClassCastException

        showUpCast(textBox);
        showDownCast(textBox);

        UIControl[] controls = {new TextBox(), new CheckBox()};
        for (var ctrl: controls)
            ctrl.render();
    }


    public static void showUpCast(UIControl uiControl) {
        System.out.println(uiControl);
    }

    public static void showDownCast(UIControl uiControl) {
        if (uiControl instanceof TextBox) {
            var textBox = (TextBox) uiControl;
            textBox.setText("Hello World");
        }
        System.out.println(uiControl);
    }
}
