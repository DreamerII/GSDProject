package com.student.gsd.gsdstudentapp.model;

/**
 * Created by dreamfire on 23.05.16.
 */
public class LoginInfo {
    private String status;
    private String message;
    private String nextstep;
    private String access_token;
    private TokenInfo token_info;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getNextstep() {
        return nextstep;
    }

    public String getAccess_token() {
        return access_token;
    }

    public TokenInfo getToken_info() {
        return token_info;
    }
}
