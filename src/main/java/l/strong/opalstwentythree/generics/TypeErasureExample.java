package l.strong.opalstwentythree.generics;

import java.util.ArrayList;
import java.util.List;

public class TypeErasureExample {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        System.out.println("String list class: " + stringList.getClass());
        System.out.println("Integer list class: " + intList.getClass());

        if (stringList.getClass() == intList.getClass()) {
            System.out.println("Both lists are of the same class due to type erasure.");
        }
    }
}
