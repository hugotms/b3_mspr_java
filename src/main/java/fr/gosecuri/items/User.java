package fr.gosecuri.items;

import org.apache.commons.codec.digest.Md5Crypt;

public class User {
    private String username;
    private String pwd;

    public User(String username, String pwd) {
        this.username = username;
        this.pwd = Md5Crypt.md5Crypt(pwd.getBytes());
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }
}
