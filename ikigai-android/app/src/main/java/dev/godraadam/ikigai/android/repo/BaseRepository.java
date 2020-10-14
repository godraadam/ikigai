package dev.godraadam.ikigai.android.repo;

import java.util.List;

import dev.godraadam.ikigai.android.repo.exception.RepositoryException;

public interface BaseRepository<T> {

    T findById(final Long id) throws RepositoryException;

    List<T> findAll() throws RepositoryException;

    void save(final T model) throws RepositoryException;

    void save(final List<T> model) throws RepositoryException;

    void deleteById(final Long id) throws RepositoryException;

    void deleteAll() throws RepositoryException;
}
