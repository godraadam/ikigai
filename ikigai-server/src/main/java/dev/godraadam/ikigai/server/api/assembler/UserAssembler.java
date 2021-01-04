package dev.godraadam.ikigai.server.api.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dev.godraadam.ikigai.common.dto.UserDTO;
import dev.godraadam.ikigai.server.model.User;

@Component
public class UserAssembler implements BaseAssembler<User, UserDTO> {

    @Autowired
    private VisitAssembler visitAssembler;

    @Override
    public UserDTO createDto(User m) {
        if (m == null) {
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setId(m.getId());
		userDTO.setUserName(m.getUserName());
		userDTO.setVisits(visitAssembler.createDTOList(m.getVisits()));
		return userDTO;
    }

    @Override
    public User createModel(UserDTO d) {
        if (d == null) {
			return null;
		}
		User user = new User();
		return updateModel(user, d);
    }

    @Override
    public User updateModel(User m, UserDTO d) {
        if (m != null) {
			m.setId(d.getId());
			if (d.getVisits() != null) {
				m.setVisits(visitAssembler.createModelList(d.getVisits()));
			}
		}
		return m;
	}
    
}
