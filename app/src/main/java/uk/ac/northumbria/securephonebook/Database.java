package uk.ac.northumbria.securephonebook;

import android.content.ContentValues;
import android.content.Context;
import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by Michael on 10/03/2017.
 */

public class Database {
    public static final String TABLE_NAME = "contact";
    public static final String FIELD_ID = "_id";
    public static final String FIELD_FIRSTNAME = "firstname";
    public static final String FIELD_SURNAME = "surname";
    public static final String FIELD_TELEPHONE = "telephone";
    public static final String FIELD_EMAIL = "email";

    Context con;
    DBHelper dbhelper;


    public Database(Context context) {
        con = context;
        dbhelper = new DBHelper(con);
    }


    public void addContact(String firstname, String surname, String telephone, String email) {
        SQLiteDatabase db = dbhelper.getWritableDatabase("Password1");
        //db.execSQL("insert into contacts (_id, firstname, secondname, telephone) values ('','Abc','123')");");
        ContentValues values = new ContentValues();
        values.put(FIELD_FIRSTNAME, firstname);
        values.put(FIELD_SURNAME, surname);
        values.put(FIELD_EMAIL, email);
        values.put(FIELD_TELEPHONE, telephone);
        db.insert(TABLE_NAME, FIELD_FIRSTNAME, values);

    }

    public ArrayList<String> getAllContacts(){
        ArrayList<String> data = new ArrayList<>();
        SQLiteDatabase db = dbhelper.getWritableDatabase("Password1");
        String[] col = {FIELD_FIRSTNAME,FIELD_SURNAME,FIELD_EMAIL,FIELD_TELEPHONE};
        Cursor cu = db.query(TABLE_NAME,col,null,null,null,null,null);

        if (cu.getCount() > 0) {
            cu.moveToFirst();
            do {
                String firstname = cu.getString(cu.getColumnIndex(FIELD_FIRSTNAME));
                String surname = cu.getString(cu.getColumnIndex(FIELD_SURNAME));
                String email = cu.getString(cu.getColumnIndex(FIELD_EMAIL));
                String telephone = cu.getString(cu.getColumnIndex(FIELD_TELEPHONE));
                String row = firstname+" "+surname+" "+email+" "+telephone;
                data.add(row);
            } while ( cu.moveToNext());
        }

        return data;
    }
}

