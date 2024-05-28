package l.strong.opalstwentythree.design.code.simplefactory;

/**
 * 简单工厂
 */
public class OperationFactory {
    public static Operation createOperate(String operate) {
        Operation operation = null;
        switch (operate) {
            case "+":
                operation = new OperationAdd();
                break;
            default:
                break;
        }
        return operation;
    }
}
