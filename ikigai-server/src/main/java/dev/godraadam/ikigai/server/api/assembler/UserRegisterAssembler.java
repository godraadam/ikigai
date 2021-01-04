package dev.godraadam.ikigai.server.api.assembler;

import java.util.Collections;

import org.springframework.stereotype.Component;

import dev.godraadam.ikigai.common.dto.UserRegisterDTO;
import dev.godraadam.ikigai.server.model.User;

@Component
public class UserRegisterAssembler implements BaseAssembler<User, UserRegisterDTO> {


    @Override
    public UserRegisterDTO createDto(User m) {
        if (m == null) {
			return null;
		}
		UserRegisterDTO userDTO = new UserRegisterDTO();
        userDTO.setId(m.getId());
        userDTO.setEmail(m.getEmail());
        userDTO.setPassWord(m.getPassWord());
        userDTO.setUserName(m.getUserName());
		return userDTO;
    }

    @Override
    public User createModel(UserRegisterDTO d) {
        if (d == null) {
			return null;
		}
		User user = new User();
		return updateModel(user, d);
    }

    @Override
    public User updateModel(User m, UserRegisterDTO d) {
        if (m != null) {
			m.setId(d.getId());
            m.setEmail(d.getEmail());
            m.setUserName(d.getUserName());
            m.setPassWord(d.getPassWord());
            m.setVisits(Collections.emptyList());
		}
		return m;
	}
}
