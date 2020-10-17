package dev.godraadam.ikigai.android.service;

import android.content.Context;

import java.util.List;

import dev.godraadam.ikigai.android.model.Visit;
import dev.godraadam.ikigai.android.repo.VisitRepository;
import dev.godraadam.ikigai.android.repo.impl.VisitRepositoryImpl;

public class VisitService {

    private VisitRepository visitRepository;

    public VisitService(Context context) {
        visitRepository = new VisitRepositoryImpl(context);
    }

    public List<Visit> getVisitedCountries() {
        return visitRepository.findAll();
    }

    public void addVisitedCountry(Visit visit) {
        visitRepository.save(visit);
    }

    public void deleteAll() {
        visitRepository.deleteAll();
    }
}
