package l.strong.opalstwentythree.design.code.proxy;

public class GamePlayer implements IGamePlayer {
    private String name = "";

    public GamePlayer(IGamePlayer _gamePlayer,String _name) throws Exception {
        if (_gamePlayer == null) {
            throw new Exception("不能创建真实角色");
        }
        this.name = _name;
    }
    @Override
    public void login(String user, String password) {
        System.out.println("登录用户名：" + user +"的用户" + name + "登陆成功");
    }

    @Override
    public void killBoss() {
        System.out.println(name + "杀怪");
    }

    @Override
    public void upgrade() {
        System.out.println(name + "升级");
    }
}
