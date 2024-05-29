package l.strong.opalstwentythree.design.code.simplefactory.factorymethod;

import l.strong.opalstwentythree.design.code.simplefactory.Operation;
import l.strong.opalstwentythree.design.code.simplefactory.OperationAdd;

public class AddFactory implements IFactory{
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
