package data;

import java.io.Serializable;

public class User implements Serializable {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //    public User(String id, String userName, String password, String email, String phoneNumber, String avatar) {
//        this.id = id;
//        this.userName = userName;
//        this.password = password;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.avatar = avatar;
//    }
    int id;
    String userName;

    public User(int id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public User(String username ,String password)
    {
        this.userName = username;
        this.password = password;
    }

    String password;
     String email;
     String phoneNumber;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    String avatar;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public User(String userName, String password, String email, String phoneNumber) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
