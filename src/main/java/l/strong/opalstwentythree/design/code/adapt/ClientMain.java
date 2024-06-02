package l.strong.opalstwentythree.design.code.adapt;

public class ClientMain {
    public static void main(String[] args) {
        IUserInfo userInfo = new OuterUserInfo();
        System.out.println(userInfo.getUserName());
        System.out.println(userInfo.getJobPosition());

        IOuterUserOfficeInfo officeInfo = new OuterUserOfficeInfo();
        IOuterUserHomeInfo homeInfo = new OuterUserHomeInfo();
        IOuterUserBasicInfo basicInfo = new OuterUserBasicInfo();
        IUserInfo userInfo1 = new UserInfo(basicInfo,homeInfo,officeInfo);
        System.out.println(userInfo1.getUserName());
        System.out.println(userInfo1.getJobPosition());
    }
}
