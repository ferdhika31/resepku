package id.web.dika.resepku.db;

/**
 * Created by ferdhika on 05/05/17.
 */

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ResepKuDAO {
    protected SQLiteDatabase database;
    protected DatabaseHelper dbHelper;
    private Context mContext;

    public ResepKuDAO(Context context) {
        this.mContext = context;
        dbHelper = DatabaseHelper.getHelper(mContext);
        open();
    }

    public void open() throws SQLException {
        if(dbHelper == null)
            dbHelper = DatabaseHelper.getHelper(mContext);
        database = dbHelper.getWritableDatabase();
    }

    /*public void close() {
        dbHelper.close();
        database = null;
    }*/
}
