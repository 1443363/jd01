package homework06.messenger;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class User implements Serializable {
    private String login;
    private String password;

    public User(String login){
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin() {
        System.out.println("Введите логин пользователя: ");
        Scanner scan = new Scanner(System.in);
        String input = "";
        while (scan.hasNext()) {
            input = scan.next();
            this.login = input;
            break;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getLogin(), user.getLogin()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPassword());
    }

    @Override
    public String toString() {
        return "User{" + "login='" + login + '\'' + '}';
    }
}
