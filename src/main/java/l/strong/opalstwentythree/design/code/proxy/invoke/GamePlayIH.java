package l.strong.opalstwentythree.design.code.proxy.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GamePlayIH implements InvocationHandler {
    //被代理者
    Class cls = null;
    //被代理的实例
    Object obj = null;

    public GamePlayIH(Object _obj) {
        this.obj = _obj;
    }
    // 调用被代理者的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = method.invoke(this.obj,args);
        //AOP思想 可以不动被代理类，而是在代理类动态执行方法时，切入
        if (method.getName().equalsIgnoreCase("login")) {
            System.out.println("有人在用我的账号登录");
        }
        return result;
    }
}
