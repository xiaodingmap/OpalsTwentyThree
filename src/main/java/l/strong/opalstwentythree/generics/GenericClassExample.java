package l.strong.opalstwentythree.generics;

public class GenericClassExample {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.setValue("Hello, Generics");
        System.out.println("String value: " + stringBox.getValue());

        Box<Integer> integerBox = new Box<>();
        integerBox.setValue(123);
        System.out.println("Integer value: " + integerBox.getValue());
    }
}
