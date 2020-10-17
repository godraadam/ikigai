package dev.godraadam.ikigai.server.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import dev.godraadam.ikigai.server.model.User;

@Component
public interface UserRepository extends CrudRepository<User, Long> {

        User findByUserName(String userName);
        User findByEmail(String email);
    
}
