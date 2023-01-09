package modelClass;

public class Users {
    private String user_name;
    private long ph_no;

    public Users() {
    }

    public Users(String user_name, long ph_no) {
        this.user_name = user_name;
        this.ph_no = ph_no;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public long getPh_no() {
        return ph_no;
    }

    public void setPh_no(long ph_no) {
        this.ph_no = ph_no;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_name='" + user_name + '\'' +
                ", ph_no=" + ph_no +
                '}';
    }
}
