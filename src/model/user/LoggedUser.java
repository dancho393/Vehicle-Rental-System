package model.user;

public class LoggedUser {
    private static LoggedUser INSTANCE;
    private User user=null;
    private LoggedUser() {

    }
    public static LoggedUser getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LoggedUser();
        }
        return INSTANCE;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
