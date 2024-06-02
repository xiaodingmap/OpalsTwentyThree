package l.strong.opalstwentythree.design.code.adapt;

public class OuterUserInfo extends OuterUser implements IUserInfo {
    @Override
    public String getUserName() {
        return super.getUserBasicInfo().get("name");
    }

    @Override
    public String getHomeAndAddress() {
        return super.getUserHomeInfo().get("address");
    }

    @Override
    public String getMobileNumber() {
        return super.getUserBasicInfo().get("mobileNumber");
    }

    @Override
    public String getOfficeTelNumber() {
        return super.getUserOfficeInfo().get("officeNumber");
    }

    @Override
    public String getJobPosition() {
        return super.getUserOfficeInfo().get("jobPosition");
    }

    @Override
    public String getHomeTelNumber() {
        return super.getUserHomeInfo().get("homeNumber");
    }
}
