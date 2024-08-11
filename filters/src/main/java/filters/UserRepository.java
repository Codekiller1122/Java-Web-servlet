import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static final Map<String, User> users = new HashMap<>();

    static {
        users.put("john", new User("john", "password123"));
        users.put("jane", new User("jane", "letmein"));
    }

    public static User getUser(String username) {
        return users.get(username);
    }
}
