package dev.godraadam.ikigai.server.api.assembler;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.godraadam.ikigai.common.dto.VisitDTO;
import dev.godraadam.ikigai.server.model.Visit;

@Component
public class VisitAssembler implements BaseAssembler<Visit, VisitDTO> {

    @Autowired
    private UserAssembler userAssembler;

    @Override
    public VisitDTO createDto(Visit m) {
        if (m == null) {
            return null;
        }
        VisitDTO visitDTO = new VisitDTO();
        visitDTO.setId(m.getId());
        visitDTO.setCountry(m.getCountry());
        visitDTO.setDate(new SimpleDateFormat("dd/MM/yyyy").format(m.getDate()));
        visitDTO.setDescription(m.getDescription());
        visitDTO.setUser(userAssembler.createDto(m.getUser()));
        return visitDTO;
    }

    @Override
    public Visit createModel(VisitDTO d) {
        if (d == null) {
			return null;
		}
		Visit visit = new Visit();
		return updateModel(visit, d);
    }

    @Override
    public Visit updateModel(Visit m, VisitDTO d) {
        if (m != null) {
            m.setId(d.getId());
            try {
                m.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(d.getDate()));
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		return m;
    }
    
}