package dev.godraadam.ikigai;

import dev.godraadam.ikigai.android.model.User;

public class Memory {

    public static User currentUser = new User();
    static {
        currentUser.setUsername("godraadam");
    }

}
