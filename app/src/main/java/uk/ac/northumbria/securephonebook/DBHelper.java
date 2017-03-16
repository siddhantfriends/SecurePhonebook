package uk.ac.northumbria.securephonebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Michael on 10/03/2017.
 */

public class DBHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "DBHELPER";
    public static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "contact";
    public static final String FIELD_ID = "_id";
    public static final String FIELD_FIRSTNAME = "firstname";
    public static final String FIELD_SURNAME = "surname";
    public static final String FIELD_TELEPHONE = "telephone";
    public static final String FIELD_EMAIL = "email";
    private static final String QUERY_CREATE = "CREATE TABLE "+TABLE_NAME+"("+FIELD_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+FIELD_FIRSTNAME+" VARCHAR (100),"+FIELD_SURNAME+" VARCHAR (100), "+FIELD_TELEPHONE+" VARCHAR (100), "+FIELD_EMAIL+" VARCHAR (100) )";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null , DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL (QUERY_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
