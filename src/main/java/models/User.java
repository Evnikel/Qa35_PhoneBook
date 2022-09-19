package models;

public class User {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public User withEmail(String email) { // поменяли с setEmail на with,
        // но это без разнийы
        this.email = email;
        return this; // или new User();
    }

    public String getPassword() {
        return password;
    }

    public User withPassword(String password) {
        this.password = password;
        return this;// или new User();
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
