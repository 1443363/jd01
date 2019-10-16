package homework06.messenger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUser {
    public static boolean checkUser(User user){
        if (user.getLogin().matches("^[^А-яЁё\\d!#\\\\].+[^А-яЁё\\d!#\\\\]{4,}")) {
            return true;
        } else {
            return false;
        }
    }
}
