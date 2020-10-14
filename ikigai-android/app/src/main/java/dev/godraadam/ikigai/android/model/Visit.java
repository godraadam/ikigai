package dev.godraadam.ikigai.android.model;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

public class Visit extends BaseModel {

    @DatabaseField(canBeNull = false)
    private String country;

    @DatabaseField(canBeNull = false)
    private Date date;

    @DatabaseField
    private String comment;

    public String getCountry() {
        return country;
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
