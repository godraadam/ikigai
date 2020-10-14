package dev.godraadam.ikigai.android.repo.impl;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;

import dev.godraadam.ikigai.android.model.Visit;
import dev.godraadam.ikigai.android.repo.DatabaseHelper;
import dev.godraadam.ikigai.android.repo.VisitRepository;
import dev.godraadam.ikigai.android.repo.exception.RepositoryException;

public class VisitRepositoryImpl extends BaseRepositoryImpl<Visit> implements VisitRepository {


    private static final String TAG = VisitRepositoryImpl.class.getSimpleName();

    public VisitRepositoryImpl(Context context) {
        super(Visit.class);
        try {
            DatabaseHelper databaseHelper = DatabaseHelper.getInstance(context);
            Dao<Visit, Long> userProfileDao = databaseHelper.getVisitDao();
            super.setDao(userProfileDao);
        } catch (SQLException e) {
            String msg = "Failed to initialize VisitRepository";
            Log.e(TAG, msg);
            throw new RepositoryException(msg, e);
        }
    }
}
