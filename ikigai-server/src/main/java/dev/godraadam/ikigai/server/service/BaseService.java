package dev.godraadam.ikigai.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import dev.godraadam.ikigai.server.model.BaseModel;

public abstract class BaseService<M extends BaseModel> {

    @Autowired
	private CrudRepository<M, Long> repository;

	public M findById(Long id) {
        return repository.findById(id).orElse(null);
    }

	public List<M> findAll() {
        List<M> result = new ArrayList<>();
		repository.findAll().forEach(it -> result.add(it));
		return result;
    }

	public void deleteById(Long id) {
        repository.deleteById(id);
    }

	public void delete(List<Long> ids) {
        ids.forEach(id -> repository.deleteById(id));
    }

	public M save(M model) {
        return repository.save(model);
    }

	public Iterable<M> save(List<M> models) {
        return repository.saveAll(models);
    }

}
