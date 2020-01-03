package ch.bfh.ti.cookingWebapp.auth.validator;

import javax.validation.constraints.NotEmpty;

public class UserLoginDto {

    @NotEmpty
    private String userNameOrMail;

    @NotEmpty
    private String password;

    public String getUserNameOrMail() {
        return userNameOrMail;
    }

    public void setUserNameOrMail(String userNameOrMail) {
        this.userNameOrMail = userNameOrMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
