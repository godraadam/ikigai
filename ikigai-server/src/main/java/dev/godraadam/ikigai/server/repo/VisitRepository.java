package dev.godraadam.ikigai.server.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import dev.godraadam.ikigai.server.model.Visit;

@Component
public interface VisitRepository extends CrudRepository<Visit, Long> {
    
}
