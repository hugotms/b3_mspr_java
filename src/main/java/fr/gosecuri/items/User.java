package fr.gosecuri.items;

import org.apache.commons.codec.digest.DigestUtils;

public class User {
    private String username;
    private String pwd;

    public User(String username, String pwd) {
        this.username = username;
        this.pwd = DigestUtils.md5Hex(pwd);
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }
}
