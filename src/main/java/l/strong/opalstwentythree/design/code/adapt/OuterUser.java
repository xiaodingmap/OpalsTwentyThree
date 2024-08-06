package l.strong.opalstwentythree.design.code.adapt;

import java.util.HashMap;
import java.util.Map;

// 这个类虽然被OuterUserInfo继承去做适配器，但本身接口并不符合单一职责，所以改写
public class OuterUser implements IOuterUserBasicInfo, IOuterUserHomeInfo, IOuterUserOfficeInfo {
    @Override
    public Map<String, String> getUserBasicInfo() {
        HashMap<String, String> basicInfo = new HashMap<>();
        basicInfo.put("name", "l");
        basicInfo.put("mobileNumber", "15445");
        return basicInfo;
    }

    @Override
    public Map<String, String> getUserHomeInfo() {
        HashMap<String, String> userHomeInfo = new HashMap<>();
        userHomeInfo.put("address", "weaweawe");
        userHomeInfo.put("homeNumber", "213123123");
        return userHomeInfo;
    }

    @Override
    public Map<String, String> getUserOfficeInfo() {
        HashMap<String, String> officeInfo = new HashMap<>();
        officeInfo.put("jobPosition", "rtryrtyrt");
        officeInfo.put("officeNumber", "123234");
        return officeInfo;
    }
}
