package l.strong.opalstwentythree.design.code.adapt;

import java.util.Timer;

public class UserInfo implements IUserInfo {
    private IOuterUserBasicInfo basicInfo;
    private IOuterUserHomeInfo homeInfo;

    private IOuterUserOfficeInfo officeInfo;

    public UserInfo(IOuterUserBasicInfo basic_Info,IOuterUserHomeInfo home_Info,IOuterUserOfficeInfo office_Info) {
        this.basicInfo = basic_Info;
        this.homeInfo = home_Info;
        this.officeInfo = office_Info;
    }
    @Override
    public String getUserName() {
        return basicInfo.getUserBasicInfo().get("name");
    }
    @Override
    public String getHomeAndAddress() {
        return homeInfo.getUserHomeInfo().get("address");
    }

    @Override
    public String getMobileNumber() {
        return basicInfo.getUserBasicInfo().get("mobileNumber");
    }

    @Override
    public String getOfficeTelNumber() {
        return officeInfo.getUserOfficeInfo().get("officeNumber");
    }

    @Override
    public String getJobPosition() {
        return officeInfo.getUserOfficeInfo().get("jobPosition");
    }

    @Override
    public String getHomeTelNumber() {
        return homeInfo.getUserHomeInfo().get("homeNumber");
    }
}
