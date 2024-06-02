package l.strong.opalstwentythree.design.code.proxy;

import java.util.Date;

public class MainClass {
    public static void main(String[] args) {
        // 普通代理，客户端只知代理对象而不知真实对象，屏蔽真实对象改变对高层模块的影响
        IGamePlayer proxy = new GamePlayerProxy("张有");
        proxy.login("zhangyou","12233");
        proxy.killBoss();
        proxy.upgrade();


    }
}
