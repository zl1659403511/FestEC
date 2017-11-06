package com.abc.latte.ec.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.abc.latte.ec.database.DaoMaster.OpenHelper;

import org.greenrobot.greendao.database.Database;

/**
 * Created by admin on 2017/9/24.
 */

public class ReleaseOpenHelper extends OpenHelper {
    public ReleaseOpenHelper(Context context, String name) {
        super(context, name);
    }

    public ReleaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onCreate(Database db) {
        super.onCreate(db);
    }
}
