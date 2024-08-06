package l.strong.opalstwentythree.design.code.proxy;

public class Proxy implements Buyer{
    //proxy代理pursuit，两者都实现buyer接口，proxy代理
    //可以让girl在不认识pursuit的情况下，通过代理人proxy享受到pursuit调用的方法
    Pursuit pursuit;
    Proxy(Girl girl){
       pursuit = new Pursuit(girl);
    }
    @Override
    public void buyFlower() {
        pursuit.buyFlower();//在实现中调用pursuit的方法
    }
}
