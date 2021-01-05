package dev.godraadam.ikigai.android.api;

import android.content.Context;
import android.os.StrictMode;

import java.io.IOException;
import java.util.List;

import dev.godraadam.ikigai.android.api.assembler.VisitAssembler;
import dev.godraadam.ikigai.android.model.Visit;
import dev.godraadam.ikigai.common.dto.VisitDTO;
import retrofit2.Call;

public class VisitApiBean {

    private VisitApi visitApi;
    private VisitAssembler visitAssembler;

    public VisitApiBean(Context context) {
        visitApi = ApiManager.getClient(context).create(VisitApi.class);
        visitAssembler = VisitAssembler.getInstance();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public List<Visit> getVisitsForUser(String user) {
        Call<List<VisitDTO>> call = visitApi.getVisitsForUser(user);
        System.out.println(user);
        List<VisitDTO> dtos = null;
        try {
            dtos = call.execute().body();
            return visitAssembler.createModelList(dtos);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
