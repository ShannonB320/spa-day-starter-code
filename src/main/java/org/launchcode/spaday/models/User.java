package org.launchcode.spaday.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class User {

    @NotBlank(message = "Must not be blank!")
    @Size(min = 5, max = 15, message = "Username must contain 5-15 characters.")
    private String username;

    @Email
    private String email;

    @NotBlank(message = "Must not be blank!")
    @Size(min = 6, message = "Password must be at least 6 characters.")
    private String password;

    @NotNull(message = "Passwords do not match.")
    private String verifyPassword;

    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword() {
        if (!Objects.isNull(this.password) && !Objects.isNull(this.verifyPassword)) {
            if(!this.password.equals(this.verifyPassword)){
                this.verifyPassword = null;
            }
        }
    }

}
