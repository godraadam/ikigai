package dev.godraadam.ikigai.android.api;

import dev.godraadam.ikigai.android.model.Visit;
import dev.godraadam.ikigai.common.dto.UserDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserApi {

    @GET("/api/user/name/{name}")
    Call<UserDTO> getUserByName(@Path(value = "name") String userName);

    @POST("/api/user/visit/{name}")
    Call<String> saveVisitForUser(@Path("name") String name, @Body Visit visit);
}
