package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.AvoidXfermode;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mouse on 5/7/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "QuanLyChiTieu";
    private static final String TABLE_CHITIEU = "ChiTieu";

    //Cot trong bang ChiTieu
    private static final String KEY_ID = "_id";
    private static final String KEY_NAME = "_name";
    private static final String KEY_MONEY = "_money";
    private static final String KEY_DATE = "_date";
    private static final String KEY_DESC = "_desc";
    private static final String KEY_THU = "_thu";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CHITIEU + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_MONEY + " TEXT," + KEY_DATE + " TEXT," + KEY_DESC + " TEXT," + " " + KEY_THU + " TEXT)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHITIEU);

        // Create tables again
        onCreate(db);
    }

    //Add New ChiTieu
    public long addChiTieu(ChiTieu chiTieu) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, chiTieu.get_NAME()); // Contact NameChiTieu
        values.put(KEY_MONEY, chiTieu.get_MONEY()); // Contact Money
        values.put(KEY_DATE, chiTieu.get_DATE()); // Contact Date
        values.put(KEY_DESC, chiTieu.get_DESC());// Contact Li Do
        values.put(KEY_THU, chiTieu.get_THU()); // neu tien thu thi = 1

        // Inserting Row
        long id = db.insert(TABLE_CHITIEU, null, values);
        db.close(); // Closing database connection
        return id;
    }
    // lay database
    public ChiTieu getChiTieu(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CHITIEU, new String[] { KEY_ID,
                        KEY_NAME, KEY_MONEY, KEY_DATE, KEY_DESC, KEY_THU }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        ChiTieu chiTieu = new ChiTieu();
        chiTieu.set_NAME(cursor.getString(1));
        chiTieu.set_MONEY(cursor.getString(2));
        chiTieu.set_DATE(cursor.getString(3));
        chiTieu.set_DESC(cursor.getString(4));
        chiTieu.set_THU(cursor.getInt(5));
        return chiTieu;
    }

    public List<ChiTieu> getAllChiTieu(String startTime, String endTime) {
        List<ChiTieu> chiTieuList = new ArrayList<ChiTieu>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_CHITIEU + " WHERE "+ KEY_DATE  +" >= " + startTime + " AND "+ KEY_DATE +" <= "+ endTime +" ORDER BY " + KEY_DATE + " ASC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ChiTieu chiTieu = new ChiTieu();
                chiTieu.set_ID(Integer.parseInt(cursor.getString(0)));
                chiTieu.set_NAME(cursor.getString(1));
                chiTieu.set_MONEY(cursor.getString(2));
                chiTieu.set_DATE(cursor.getString(3));
                chiTieu.set_DESC(cursor.getString(4));
                chiTieu.set_THU(cursor.getInt(5));
                // Adding chitieu to list
                chiTieuList.add(chiTieu);
            } while (cursor.moveToNext());
        }

        // return contact list
        return chiTieuList;
    }
}
