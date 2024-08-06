package l.strong.opalstwentythree.design.code.adapt;

import java.util.HashMap;
import java.util.Map;

public class OuterUserHomeInfo implements IOuterUserHomeInfo{
    @Override
    public Map<String, String> getUserHomeInfo() {
        HashMap<String, String> userHomeInfo = new HashMap<>();
        userHomeInfo.put("address", "weaweawe");
        userHomeInfo.put("homeNumber", "213123123");
        return userHomeInfo;
    }
}
