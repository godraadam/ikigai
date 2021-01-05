package dev.godraadam.ikigai.android.api.assembler;

import java.util.ArrayList;
import java.util.List;

import dev.godraadam.ikigai.android.model.User;
import dev.godraadam.ikigai.common.dto.UserDTO;

public class UserAssembler implements BaseAssembler<User, UserDTO> {


    private static UserAssembler instance;
    private VisitAssembler visitAssembler = VisitAssembler.getInstance();

    private UserAssembler() {
    }

    public static UserAssembler getInstance() {
        if (instance == null) {
            instance = new UserAssembler();
        }
        return instance;
    }

    @Override
    public User createModel(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        return updateModel(user, dto);
    }

    @Override
    public User updateModel(User user, UserDTO userDTO) {
        user.setUsername(userDTO.getUserName());
        user.setVisits(visitAssembler.createModelList(userDTO.getVisits()));
        return user;

    }

    @Override
    public List<User> createModelList(List<UserDTO> userDTOS) {
        List<User> users = new ArrayList<>();
        for (UserDTO dto : userDTOS) {
            users.add(createModel(dto));
        }
        return users;
    }
}
