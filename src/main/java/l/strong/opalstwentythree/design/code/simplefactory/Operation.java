package l.strong.opalstwentythree.design.code.simplefactory;

import lombok.Data;

@Data
public class Operation {
    private double strNumberA;
    private double strNumberB;

    public double getResult() {
        return strNumberA + strNumberB;
    }
}
