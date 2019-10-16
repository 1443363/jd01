package homework06.messenger;

import java.util.Objects;
import java.util.Scanner;

public class User {
    private String login;
    private String password;

    public User(String password){
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin() {
        System.out.println("Введите логин пользователя, для подтверждения ввода логина введите \"enter\".");
        Scanner scan = new Scanner(System.in);
        String input = "";
        while (scan.hasNext() && !input.equalsIgnoreCase("enter")) {
            input = scan.next();
            if (!input.equalsIgnoreCase("enter")) {
                this.login = input;
                break;
            } else break;
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
