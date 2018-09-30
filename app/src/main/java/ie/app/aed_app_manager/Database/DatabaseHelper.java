package ie.app.aed_app_manager.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "AED.db";
    private static final String TABLE_NAME = "user_table";

    private static final String COL_1 = "AED_ID";
    private static final String COL_2 = "AED_Location";
    private static final String COL_3 = "AED_Condition";
    private static final String COL_4 = "AED_Service_Date";

    //-----------------------------Constructor------------------------------------------------------
    public DatabaseHelper(Context context)         //creates DB when called
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //  SQLiteDatabase db = this.getWritableDatabase();
    }
    //----------------------------------------------------------------------------------------------

    @Override
    public void onCreate(SQLiteDatabase db)     //creates table when called
    {
        String CREATE_AED_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COL_1 + " TEXT PRIMARY KEY,"
                + COL_2 + " TEXT,"
                + COL_3 + " TEXT,"
                + COL_4 + " TEXT " + ")";

        db.execSQL(CREATE_AED_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String id, String location, String condition, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,location);
        contentValues.put(COL_3,condition);
        contentValues.put(COL_4,date);

        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();   //creating instance of DB
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);  //creating instance of cursor class
        //while(res.is)
        return res;
    }

    public boolean updateData(String id,String location,String condition, String date) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();   // content value instance
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,location);
        contentValues.put(COL_3,condition);
        contentValues.put(COL_4,date);
        long result = db.insert(TABLE_NAME,null, contentValues);   //returns either -1 or the correct row
        if(result == -1)
            return false;
        else
            return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}
