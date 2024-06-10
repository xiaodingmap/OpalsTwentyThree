package l.strong.opalstwentythree.design.code.concrete;

public class ConcreteDecorator1 extends Decorator{
    public ConcreteDecorator1(Component _component) {
        super(_component);
    }
    private void method1() {
        System.out.println("method1 修饰");
    }

    @Override
    public void operate() {
        this.method1();
        super.operate();
    }
}
