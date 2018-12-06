package com.codecool.foodswap.util;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RegistrationForm {

    @NotBlank(message = "Enter a valid first name!")
    private String firstName;

    @NotBlank(message = "Enter a valid last name!")
    private String lastName;

    @NotBlank(message = "Enter a valid e-mail address!")
    @Email(message = "Enter a valid e-mail address!")
    private String email;

    @Size(min = 5, message = "Password must be at least 5 characters long!")
    private String password;

    private String password2;

    @AssertTrue(message="Passwords must match!")
    private boolean isValid() {
        return password.equals(password2);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getPassword() {
        return password;
    }
}
