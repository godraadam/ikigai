package dev.godraadam.ikigai.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.ikigai.server.model.User;
import dev.godraadam.ikigai.server.repo.UserRepository;

@Service
public class UserService extends BaseService<User> {

    @Autowired 
    private UserRepository userRepository;

    public User getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }
    
}
