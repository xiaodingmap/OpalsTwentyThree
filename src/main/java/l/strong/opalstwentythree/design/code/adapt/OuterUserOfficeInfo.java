package l.strong.opalstwentythree.design.code.adapt;

import java.util.HashMap;
import java.util.Map;

public class OuterUserOfficeInfo implements IOuterUserOfficeInfo{
    @Override
    public Map<String, String> getUserOfficeInfo() {
        HashMap<String, String> officeInfo = new HashMap<>();
        officeInfo.put("jobPosition", "rtryrtyrt");
        officeInfo.put("officeNumber", "123234");
        return officeInfo;
    }
}
