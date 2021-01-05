package dev.godraadam.ikigai.android.api;

import android.content.Context;
import android.os.StrictMode;

import java.io.IOException;
import java.util.List;

import dev.godraadam.ikigai.android.api.assembler.UserAssembler;
import dev.godraadam.ikigai.android.api.assembler.VisitAssembler;
import dev.godraadam.ikigai.android.model.User;
import dev.godraadam.ikigai.android.model.Visit;
import retrofit2.Call;

public class UserApiBean {

    private UserApi userApi;
    private UserAssembler userAssembler;
    private VisitAssembler visitAssembler;

    public UserApiBean(Context context) {
        userApi = ApiManager.getClient(context).create(UserApi.class);
        userAssembler = UserAssembler.getInstance();
        visitAssembler = VisitAssembler.getInstance();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public String saveVisitForUser(User user, Visit visit) {
        Call<String> call = userApi.saveVisitForUser(user.getUsername(), visit);
        try {
            return call.execute().body();
        } catch (IOException e) {
        }
        return null;
    }
}
