package dev.godraadam.ikigai.android.service;

import android.content.Context;

import java.util.List;

import dev.godraadam.ikigai.Memory;
import dev.godraadam.ikigai.android.api.UserApiBean;
import dev.godraadam.ikigai.android.api.VisitApiBean;
import dev.godraadam.ikigai.android.model.Visit;
import dev.godraadam.ikigai.android.repo.VisitRepository;
import dev.godraadam.ikigai.android.repo.impl.VisitRepositoryImpl;

public class VisitService {

    private VisitRepository visitRepository;
    private UserApiBean userApiBean;
    private VisitApiBean visitApiBean;

    public VisitService(Context context) {
        visitRepository = new VisitRepositoryImpl(context);
        userApiBean = new UserApiBean(context);
        visitApiBean = new VisitApiBean(context);
    }

    public List<Visit> getVisitedCountries() {
        return visitRepository.findAll();
    }

    public void addVisitedCountry(Visit visit) {
        visitRepository.save(visit);
        System.out.println(visit.getCountry());
        userApiBean.saveVisitForUser(Memory.currentUser, visit);
    }

    public List<Visit> getVisitsForUser(String username) {
        return visitApiBean.getVisitsForUser(username);
    }

    public void deleteAll() {
        visitRepository.deleteAll();
    }
}
