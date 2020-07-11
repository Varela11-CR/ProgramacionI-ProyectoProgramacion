package Models;

public class User {

    private String userName;
    private String userPassword;
    private int permissions;

    //  Constructors
    public User() {
    }

    public User(String userName, String userPassword, int permissions) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.permissions = permissions;
    }

    //  Setter's
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setPermissions(int permissions) {
        this.permissions = permissions;
    }

    //  Getter's
    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public int getPermissions() {
        return permissions;
    }

}
