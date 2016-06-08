package list.ado.to.rsantosh.com.todolist.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import list.ado.to.rsantosh.com.todolist.Model.Details;
import list.ado.to.rsantosh.com.todolist.Model.ListDetails;

/**
 * Created by C S Ramachandran on 04-06-2016.
 */
public class PurchaseDbHelper extends SQLiteOpenHelper{

    //Declaration of variables.
    //This is table name.
    private static final String HOUSE_PURCHASE = "purchase" ;
    //This is the coloumn name and is the primary key of the table.
    private static final String PUR_ID = "purchaseId";
    //This is the name of coloumn product name.
    private static final String PRODUCT_NAME = "productName";
    //This is the name of coloumn product time.
    private static final String PUR_TIME = "purchaseTime";
    //This is the name of coloumn product date.
    private static final String PUR_DATE = "purchaseDate";
    //This is the name of data base.
    private static final String DB_NAME = "todo";
    //This is the version.
    private static final int DB_VERSION = 1;


    //Creating object for SQLLite database.
    SQLiteDatabase db;

    public PurchaseDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String strCreatePurchaseTable ="create table " + HOUSE_PURCHASE + "(" + PUR_ID + " integer primary key, " + PRODUCT_NAME + " text, " + PUR_TIME + " text," + PUR_DATE + " text);";

        sqLiteDatabase.execSQL(strCreatePurchaseTable);
        Log.d("query",strCreatePurchaseTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertPurchase(String strName, String strTime, String strDate){

        db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(PRODUCT_NAME,strName);
        //Log.e("Name",strName);
        values.put(PUR_TIME,strTime);
        values.put(PUR_DATE,strDate);

        db.insert(HOUSE_PURCHASE,null,values);
        db.close();

    }

    public int Modify(int Id, String NewName, String NewDate, String NewTime){

        db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(PRODUCT_NAME,NewName);
        values.put(PUR_TIME,NewTime);
        values.put(PUR_DATE,NewDate);

        db.update(HOUSE_PURCHASE,values,PUR_ID + "=?", new String[]{String.valueOf(Id)});

        db.close();
        return 0;
    }

    public ArrayList<ListDetails> getData() {

        ArrayList<ListDetails> objDetails = new ArrayList<>();
        db = getReadableDatabase();
        String Query = "Select * from " + HOUSE_PURCHASE;
        Cursor cursor = db.rawQuery(Query,null);

            if(cursor.moveToFirst()){

                do {

                    int id = cursor.getInt(0);


                    String name = cursor.getString(1);

                    String date = cursor.getString(2);

                    String time = cursor.getString(3);


                    ListDetails detail = new ListDetails(id,name,date,time);
                    objDetails.add(detail);

                }while (cursor.moveToNext());

            }

            db.close();

            return objDetails;
        }

    public int DeleteRecord(int Id){

        db = getWritableDatabase();

        db.delete(HOUSE_PURCHASE,PUR_ID + "=?", new String[]{String.valueOf(Id)});

        db.close();
        return 0;
    }
}
