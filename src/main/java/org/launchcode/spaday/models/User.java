package org.launchcode.spaday.models;

import javax.validation.constraints.*;

public class User {
    @NotBlank(message="Username is required.")
    @Size(min=5, max=15, message="Username must be between 5 and 15 characters.")
    private String username;

    @Email(message="Email must be proper e-mail format.")
    private String email;

    @NotBlank(message="Password is required.")
    @Size(min=6, message="Password must be at least 6 characters long.")
    private String password;

    @NotBlank(message="Verify is required.")
    private String verify;

    @NotNull(message="Passwords do not match")
    private String verifyPassword;


    public User() {

    }

    public User(String username, String email, String password, String verify, String verifyPassword) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify = verify;
        this.verifyPassword = verifyPassword;
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

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword () {
        if (this.password != null && this.verifyPassword != null &&
                !(this.verifyPassword.equals(this.password))) {
            this.verifyPassword = null;
        }

    }
}