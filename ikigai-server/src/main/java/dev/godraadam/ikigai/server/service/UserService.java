package dev.godraadam.ikigai.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.godraadam.ikigai.server.model.User;
import dev.godraadam.ikigai.server.model.Visit;
import dev.godraadam.ikigai.server.repo.UserRepository;
import dev.godraadam.ikigai.server.repo.VisitRepository;

@Service
public class UserService extends BaseService<User> {

    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private VisitRepository visitRepository;

    public User getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public List<Visit> getVisitsForUser(String userName) {
        User user = userRepository.findByUserName(userName);
        if (user == null) {
            return null;
        }
        return user.getVisits();
    }

    public User saveVisitForUser(User user, Visit visit) {
        if (visit == null || user == null) {
            return null;
        }
        user.getVisits().add(visit);
        visitRepository.save(visit);
        return userRepository.save(user);
    }

    public User registerUser(User user) {
        //check email
        if (userRepository.findByEmail(user.getEmail()) != null) {
            return null;
        }
        
        //check username
        if (userRepository.findByUserName(user.getUserName()) != null) {
            return null;
        }
        //hash password here
        return userRepository.save(user);
    }
    
}
