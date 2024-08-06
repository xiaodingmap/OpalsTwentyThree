package l.strong.opalstwentythree.design.code.concrete;

public class ConcreteDecorator2 extends Decorator {
    public ConcreteDecorator2(Component _component) {
        super(_component);
    }
    private void method2() {
        System.out.println("method2 修饰");
    }

    @Override
    public void operate() {
        this.method2();
        super.operate();
    }
}
