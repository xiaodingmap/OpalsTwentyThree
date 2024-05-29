package l.strong.opalstwentythree.design.code.simplefactory;

import l.strong.opalstwentythree.design.code.simplefactory.factorymethod.AddFactory;
import l.strong.opalstwentythree.design.code.simplefactory.factorymethod.IFactory;

public class Client {
    public static void main(String[] args) {
        //工厂方法模式，将选择实力化哪个工厂交给客户端
        IFactory factory = new AddFactory();
        Operation operation = factory.createOperation();
        operation.setStrNumberA(1.0);
        operation.setStrNumberB(3.0);
        double result = operation.getResult();
        System.out.println(result);

        //简单工厂，
        Operation operate = OperationFactory.createOperate("+");
        operate.setStrNumberB(2.0);
        operate.setStrNumberA(2.0);
        double operateResult = operate.getResult();

    }
}
