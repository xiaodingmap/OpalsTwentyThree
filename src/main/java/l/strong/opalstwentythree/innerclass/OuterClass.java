package l.strong.opalstwentythree.innerclass;

/**
 * 成员内部类
 */
//public class OuterClass {
//    private String outerField = "Outer Field";
//
//    class InnerClass {
//        public void display() {
//            System.out.println("Accessing outer field:" + outerField);
//        }
//    }
//
//    public static void main(String[] args) {
//        OuterClass outer = new OuterClass();
//        InnerClass innerClass = outer.new InnerClass();
//        innerClass.display();
//    }
//}


/**
 * 局部内部类
 */
//public class OuterClass {
//
//    public void display() {
//        class LocalInnerClass {
//            void print() {
//                System.out.println("This is a local inner class." );
//            }
//        }
//        LocalInnerClass localInnerClass = new LocalInnerClass();
//        localInnerClass.print();
//    }
//
//
//    public static void main(String[] args) {
//        OuterClass outer = new OuterClass();
//        outer.display();
//    }
//}

/**
 * 匿名内部类
 */
//public class OuterClass {
//
//    public void display() {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("This is an anonymous inner class." );
//            }
//        };
//        runnable.run();
//    }
//
//
//    public static void main(String[] args) {
//        OuterClass outer = new OuterClass();
//        outer.display();
//    }
//}

/**
 * 静态内部类
 */
public class OuterClass {
    private static String staticOuterField = "Static outer field";

    static class StaticNestedClass {
        public void display() {
            System.out.println("Accessing static outer field: " + staticOuterField);
        }
    }


    public static void main(String[] args) {
        StaticNestedClass nestedClass = new OuterClass.StaticNestedClass();
        nestedClass.display();
    }
}