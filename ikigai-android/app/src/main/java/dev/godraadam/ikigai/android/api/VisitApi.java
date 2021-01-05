package dev.godraadam.ikigai.android.api;

import java.util.List;

import dev.godraadam.ikigai.common.dto.VisitDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface VisitApi {
    @GET("/api/visit/{name}")
    Call<List<VisitDTO>> getVisitsForUser(@Path("name") String name);
}
