package com.abc.latte.ec.database;

import android.content.Context;

import org.greenrobot.greendao.database.Database;

/**
 * Created by admin on 2017/9/24.
 */

public class DataBaseManager {
    private DaoSession mDaoSession = null;
    private UserProfileDao mDao = null;

    public DataBaseManager() {
    }

    public DataBaseManager init(Context context) {
        innitDao(context);
        return this;
    }

    private static final class Holer {
        private static final DataBaseManager INSTANCE = new DataBaseManager();
    }

    public static  DataBaseManager getInstance() {
        return Holer.INSTANCE;
    }

    private void innitDao(Context context) {
        final ReleaseOpenHelper helper = new ReleaseOpenHelper(context, "fast_ec.db");
        final Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
        mDao = mDaoSession.getUserProfileDao();
    }

    public final UserProfileDao getDao() {
        return mDao;
    }
}
