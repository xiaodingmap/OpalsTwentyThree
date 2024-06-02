package l.strong.opalstwentythree.design.code.adapt;

import java.util.HashMap;
import java.util.Map;

public class OuterUserBasicInfo implements IOuterUserBasicInfo{
    @Override
    public Map<String, String> getUserBasicInfo() {
        HashMap<String, String> basicInfo = new HashMap<>();
        basicInfo.put("name", "l");
        basicInfo.put("mobileNumber", "15445");
        return basicInfo;
    }
}
