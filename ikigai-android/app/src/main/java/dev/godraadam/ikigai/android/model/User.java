package dev.godraadam.ikigai.android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User extends BaseModel {

    @Expose
    @SerializedName("email")
    private String email;
    @SerializedName("userName")
    @Expose
    private String userName;

    @SerializedName("visits")
    @Expose
    private List<Visit> visits;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", visits=" + visits +
                '}';
    }
}
