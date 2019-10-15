package homework06.messenger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUser {
    public static boolean checkUser(User user){
        Pattern p = Pattern.compile("^[\\dА-яЁё!#\\\\]+[A-Za-z\\d]{4,}");
        Matcher m = p.matcher(user.getLogin());
//        if(user.getLogin().matches("^[dА-яЁё!#\\\\]+"))
//        {return false;} else {return true;}
        while(m.find()) {
            return false;
        }
        return true;
    }
}
