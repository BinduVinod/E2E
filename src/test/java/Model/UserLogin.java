package Model;

public class UserLogin {
    private String emailID;
    private String password;

    public UserLogin(String emailid, String password) {
        this.emailID = emailid;
        this.password = password;
    }

    public String getEmailid() {
        return emailID;
    }

    public void setEmailid(String emailid) {
        this.emailID = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
