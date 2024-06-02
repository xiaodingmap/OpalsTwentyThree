package l.strong.opalstwentythree.design.code.proxy.forceproxy;

//强制代理，目的是从真实角色查到代理角色，不允许直接访问真实角色。
public interface IGamePlayer {
    public void login(String user,String password);

    public void killBoss();

    public void upgrade();

    public IGamePlayer getProxy();
}
