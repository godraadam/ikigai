package dev.godraadam.ikigai.android.api.assembler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dev.godraadam.ikigai.android.model.Visit;
import dev.godraadam.ikigai.common.dto.VisitDTO;

public class VisitAssembler implements BaseAssembler<Visit, VisitDTO> {

    private static VisitAssembler instance;

    private VisitAssembler() {
    }

    public static VisitAssembler getInstance() {
        if (instance == null) {
            instance = new VisitAssembler();
        }
        return instance;
    }

    @Override
    public synchronized Visit createModel(VisitDTO dto) {
        if (dto == null) {
            return null;
        }
        Visit visit = new Visit();
        return updateModel(visit, dto);
    }

    @Override
    public synchronized Visit updateModel(Visit visit, VisitDTO dto) {
        visit.setComment(dto.getDescription());
        visit.setCountry(dto.getCountry());
        try {
            visit.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return visit;
    }


    @Override
    public List<Visit> createModelList(List<VisitDTO> dtos) {
        List<Visit> visits = new ArrayList<>();
        for (VisitDTO dto : dtos) {
            visits.add(createModel(dto));
        }
        return visits;
    }
}
