package dev.godraadam.ikigai.android.repo;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import dev.godraadam.ikigai.android.R;
import dev.godraadam.ikigai.android.model.Visit;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getSimpleName();
    private static final String DATABASE_NAME = "ikigai.db";
    private static final int DATABASE_VERSION = 3;

    private static DatabaseHelper instance;

    private Dao<Visit, Long> visitDao;

    private DatabaseHelper(final Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    public static DatabaseHelper getInstance(final Context context) {
        if (instance == null) {
            instance = new DatabaseHelper(context);
            instance.getWritableDatabase();
        }
        return instance;
    }

    @Override
    public void onCreate(final SQLiteDatabase sqliteDatabase, final ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Visit.class);
        } catch (final SQLException e) {
            Log.e(TAG, "Unable to create databases", e);
        }
    }

    @Override
    public void onUpgrade(final SQLiteDatabase sqliteDatabase, final ConnectionSource connectionSource,
                          final int oldVer, final int newVer) {
        try {
            if (oldVer < newVer) {
                TableUtils.dropTable(connectionSource, Visit.class, true);
            }
        } catch (final Exception e) {
            Log.e(TAG, "Unable to upgrade database from version " + oldVer + " to new " + newVer, e);
        }
        try {
            onCreate(sqliteDatabase, connectionSource);
        } catch (final Exception e) {
            Log.e(TAG, "Unable to create databases", e);
        }
    }

    public Dao<Visit, Long> getVisitDao() throws SQLException {
        if (visitDao == null) {
            visitDao = getDao(Visit.class);
        }
        return visitDao;
    }

    @Override
    public void close() {
        super.close();
        visitDao = null;
    }
}
