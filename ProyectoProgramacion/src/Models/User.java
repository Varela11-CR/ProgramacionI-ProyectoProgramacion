package Models;

/**
 * @author JD101
 * 
 * Su función es tomar a un usuario y sus características que está registrado 
 * en la base de datos para convertirlo en un objeto Java. 
 */
public class User {

    private String userName;
    private String userPassword;
    private int permissions;

    //  Constructors
    /**
     * Constructor vacio.
     */
    public User() {
    }

    /**
     * Este constructor inicializa los atributos de acuerdo a los parámetros 
     * ingresados.
     * @param userName
     * @param userPassword
     * @param permissions 
     */
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
