package l.strong.opalstwentythree.design.code.simplefactory;

public class OperationAdd extends Operation{

    @Override
    public double getResult() {
        return getStrNumberA() + getStrNumberB();
    }
}
