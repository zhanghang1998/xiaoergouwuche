package zyh.com.bean;

public class UserInfo {

    /**
     * headPic : http://172.17.8.100/images/small/default/user.jpg
     * nickName : WJ_hw0z3
     * phone : 15801135898
     * sessionId : 1547858859568980
     * sex : 1
     * userId : 980
     */

    private String headPic;
    private String nickName;
    private String phone;
    private String sessionId;
    private int sex;
    private long userId;

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
