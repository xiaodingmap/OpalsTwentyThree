package l.strong.opalstwentythree.design.code.proxy.forceproxy;

import java.nio.channels.NonReadableChannelException;

public class GamePlayer implements IGamePlayer {
    private String name = "";
    private IGamePlayer proxy = null;

    public GamePlayer(String _name) {
        this.name = _name;
    }

    @Override
    public void login(String user, String password) {
        if (this.isProxy()) {
            System.out.println("登录用户名：" + user + "的用户" + name + "登陆成功");
        } else {
            System.out.println("请使用指定代理访问");

        }
    }

    @Override
    public void killBoss() {
        if (this.isProxy()) {
            System.out.println(name + "杀怪");
        } else {
            System.out.println("请使用指定代理访问");

        }
    }

    @Override
    public void upgrade() {
        if (this.isProxy()) {
            System.out.println(name + "升级");
        } else {
            System.out.println("请使用指定代理访问");

        }
    }

    @Override
    public IGamePlayer getProxy() {
        this.proxy = new GamePlayerProxy(this);
        return this.proxy;
    }

    private boolean isProxy() {
        if (this.proxy == null) {
            return false;
        } else {
            return true;
        }
    }
}
