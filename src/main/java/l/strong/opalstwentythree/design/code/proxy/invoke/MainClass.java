package l.strong.opalstwentythree.design.code.proxy.invoke;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainClass {
    public static void main(String[] args) throws Exception {
        IGamePlayer player = new GamePlayer("张三");//真实对象
        InvocationHandler handler = new GamePlayIH(player);//动态代理器

        ClassLoader cl = player.getClass().getClassLoader();
        //new Class[]{IGamePlayer.class}
        IGamePlayer player1 = (IGamePlayer) Proxy.newProxyInstance(cl, player.getClass().getInterfaces(), handler);
        player1.login("zhangs","23213");
        player1.killBoss();
        player1.upgrade();

    }
}
