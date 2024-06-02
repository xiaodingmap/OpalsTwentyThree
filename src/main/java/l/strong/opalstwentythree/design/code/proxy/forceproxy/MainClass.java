package l.strong.opalstwentythree.design.code.proxy.forceproxy;
// 普通代理，客户端只知代理对象而不知真实对象，屏蔽真实对象改变对高层模块的影响
//强制代理，高层只需要从getProxy()就可以访问真实角色的所有方法，根本不需要产生一个代理出来，代理管理由真实角色自己完成
public class MainClass {
    public static void main(String[] args) {

        IGamePlayer player = new GamePlayer("张有");
        IGamePlayer proxy1 = player.getProxy();
        proxy1.login("zhangyou","12233");
        proxy1.killBoss();
        proxy1.upgrade();


    }
}
