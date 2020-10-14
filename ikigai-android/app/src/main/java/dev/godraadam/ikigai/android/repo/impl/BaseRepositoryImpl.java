package dev.godraadam.ikigai.android.repo.impl;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

import dev.godraadam.ikigai.android.model.BaseModel;
import dev.godraadam.ikigai.android.repo.BaseRepository;
import dev.godraadam.ikigai.android.repo.exception.RepositoryException;

public class BaseRepositoryImpl<T extends BaseModel> implements BaseRepository<T> {

    private final String clazzName;
    private Dao<T, Long> dao;
    private String clazzNames;

    BaseRepositoryImpl(Class<T> clazz) {
        clazzName = clazz.getSimpleName().toLowerCase();
        clazzNames = clazzName + "s";
    }

    @Override
    public T findById(Long id) throws RepositoryException {
        try {
            return dao.queryForId(id);
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public List<T> findAll() throws RepositoryException {
        try {
            return dao.queryForAll();
        } catch (final SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void save(T model) throws RepositoryException {
        try {
            dao.createOrUpdate(model);
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void save(List<T> models) throws RepositoryException {
        try {
            for (final T model : models) {
                dao.createOrUpdate(model);
            }
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void deleteById(Long id) throws RepositoryException {
        try {
            dao.deleteById(id);
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    @Override
    public void deleteAll() throws RepositoryException {
        try {
            DeleteBuilder<T, Long> deleteBuilder = dao.deleteBuilder();
            deleteBuilder.delete();
        } catch (SQLException e) {
            throw new RepositoryException(e);
        }
    }

    protected void setDao(Dao<T, Long> dao) {
        this.dao = dao;
    }
}
