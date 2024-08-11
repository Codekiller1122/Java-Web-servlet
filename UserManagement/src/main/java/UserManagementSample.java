import java.util.ArrayList;
import java.util.List;

public class UserManagementSample {
    private List<User> userList;

    public UserManagementSample() {
        userList = new ArrayList<>();
        addUser(new User("admin", "admin123"));
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User getUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean isUsernameAvailable(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public boolean authenticateUser(String username, String password) {
        User user = getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
