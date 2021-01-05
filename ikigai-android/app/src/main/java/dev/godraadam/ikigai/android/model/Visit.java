package dev.godraadam.ikigai.android.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

public class Visit extends BaseModel {

    @Expose
    @SerializedName("country")
    @DatabaseField(canBeNull = true)
    private String country;

    @Expose
    @SerializedName("date")
    private Date date;

    @Expose
    @SerializedName("description")
    @DatabaseField
    private String comment;

    public String getCountry() {
        return country;
    }

    public Visit() {}

    public Visit(String country) {
        this.country = country;
        date = new Date();
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
