package dev.godraadam.ikigai.android.model;

import com.j256.ormlite.field.DatabaseField;

public abstract class BaseModel {

    @DatabaseField(index = true, generatedId = true)
    private Long id;

    public Long getId() {
        return id;
    }
}
