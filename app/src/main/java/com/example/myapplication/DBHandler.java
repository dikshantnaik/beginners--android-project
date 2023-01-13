package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "libraryLog";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "log";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String NAME_COL = "studentName";

    // below variable id for our course duration column.
    private static final String ADMISSION_NO = "addmissionNo";

    // below variable for our course description column.
    private static final String CLASSS_COL = "classs";

    // below variable is for our course tracks column.
    private static final String COURSE_COL = "course";

    private static final String DATE_COL = "visitDate";


    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + ADMISSION_NO + " TEXT,"
                + CLASSS_COL + " TEXT,"
                + COURSE_COL + " TEXT,"
                + DATE_COL+" DATETIME DEFAULT CURRENT_TIMESTAMP)";

        // Create Admin Table



        db.execSQL(query);


    }

    // this method is use to add new course to our sqlite database.
    public void addLog(String courseName, String courseDuration, String courseDescription, String courseTracks) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, courseName);
        values.put(ADMISSION_NO, courseDuration);
        values.put(CLASSS_COL, courseDescription);
        values.put(COURSE_COL, courseTracks);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Cursor fetch() {
//        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.SUBJECT, DatabaseHelper.DESC };
        String[] columns = new String[] {ID_COL,NAME_COL, ADMISSION_NO, COURSE_COL,DATE_COL};

        try{
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();

        }
            return cursor;
        }
        catch(Exception e){
            Log.e("DATABASE_ERROR", "fetch: ERROR)"+e);
            return  null;
        }

    }

}
