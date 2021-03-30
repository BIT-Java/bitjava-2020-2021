package pl.edu.knbit.bitjava.shop.security.jwt;

/**
 * Created by surjak on 08.01.2021
 */
public class LoginRequest {
    private String username;
    private String password;

    public LoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
