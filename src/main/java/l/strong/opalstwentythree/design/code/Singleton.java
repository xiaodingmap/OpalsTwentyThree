package l.strong.opalstwentythree.design.code;

//public class Singleton {
//
//    private static final Singleton SINGLETON = new Singleton();
//    //限制产生多个对象
//    private Singleton() {
//
//    }
//
//    //通过该方法获得实例对象
//    public static Singleton getInstance() {
//        return SINGLETON;
//    }
//
//    /**
//     * 类中其他方法尽量static
//     */
//    public static void doSomeThing() {
//
//    }
//
//}

import java.util.ArrayList;
import java.util.Random;

public class Singleton {

    private static Singleton singleton = null;
    //限制产生多个对象
    private Singleton() {

    }
    //通过该方法获得实例对象
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}

//// 以2个皇帝的实例对象为例
//public class Emperor {
//
//    private static int maxNumOfEmperor = 2;
//    //皇帝名称 私有属性
//    private static ArrayList<String> nameList = new ArrayList<>();
//    //皇帝实例列表
//    private static ArrayList<Emperor> emperors = new ArrayList<>();
//
//    private static int countNumOfEmperor = 0;
//
//    private Emperor(String name) {
//        nameList.add(name);
//    }
//    static {
//        for (int i = 0; i < maxNumOfEmperor;i++) {
//            emperors.add(new Emperor("皇" + (i + 1) + "帝"));
//        }
//    }
//    //限制产生多个对象
//    private Emperor() {
//    }
//
//
//    //通过该方法获得实例对象
//    public static Emperor getInstance() {
//        Random random = new Random();
//        countNumOfEmperor = random.nextInt(maxNumOfEmperor);
//        return emperors.get(countNumOfEmperor);
//    }
//
//    public static void say() {
//        System.out.println(nameList.get(countNumOfEmperor));
//    }
//}
