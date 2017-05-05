package id.web.dika.resepku.db;

/**
 * Created by ferdhika on 05/05/17.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String NAMA_DB = "resepku.db";
    private static final int VERSI_DB = 1;

    private static DatabaseHelper instance;

    /* Tabel Config */
    public static final String RESEP_TABLE = "resep";

    public static final String FIELD_ID = "id";
    public static final String FIELD_NAMA = "nama";
    public static final String FIELD_WAKTU = "waktu";
    public static final String FIELD_BAHAN = "bahan";
    public static final String FIELD_CARA = "cara";
    public static final String FIELD_KETERANGAN = "keterangan";
    public static final String FIELD_IMAGE = "image";
    public static final String FIELD_CREATE_DATE = "created_at";

    public static final String CREATE_RESEP_TABLE = "CREATE TABLE "+RESEP_TABLE+" ("+
            "    "+FIELD_ID+"                   INTEGER PRIMARY KEY     AUTOINCREMENT," +
            "    "+FIELD_NAMA+"                 VARCHAR (32)," +
            "    "+FIELD_WAKTU+"                VARCHAR (100)," +
            "    "+FIELD_BAHAN+"                TEXT (512)," +
            "    "+FIELD_CARA+"                 TEXT (512)," +
            "    "+FIELD_KETERANGAN+"           VARCHAR (255),"+
//            "    "+FIELD_IMAGE+"           BLOB NOT NULL,"+
            "    "+FIELD_CREATE_DATE+"          DATETIME DEFAULT CURRENT_TIMESTAMP"+
            ")";

    public static synchronized DatabaseHelper getHelper(Context context) {
        if (instance == null)
            instance = new DatabaseHelper(context);
        return instance;
    }

    private DatabaseHelper(Context context) {
        super(context, NAMA_DB, null, VERSI_DB);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=off;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RESEP_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + RESEP_TABLE);

        // create new tables
        onCreate(db);
    }
}
