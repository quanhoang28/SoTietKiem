package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sotietkiem.fragment.HistoryFragment;

import java.util.ArrayList;

public class DataQuery {


    public static void insert(Context context, User user)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(helper.COLUMN_USERNAME,user.userName);
        values.put(helper.COLUMN_PASSWORD,user.password);
        db.insert(helper.TABLE_NAME,null,values);
        db.close();
    }

    public static boolean delete(Context context , int id )
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        int rs = sqLiteDatabase.delete(helper.TABLE_NAME,helper.COLUMN_ID+ "=?", new String[]{String.valueOf(id)});
        return (rs>0);
    }


    public static ArrayList<User> getAll(Context context)
    {
        ArrayList<User> lstUser = new ArrayList<>();
        DatabaseHandler userDataHelper = new DatabaseHandler(context);
        SQLiteDatabase db = userDataHelper.getReadableDatabase();
        Cursor cs = db.rawQuery("Select * from " + DatabaseHandler.TABLE_NAME,null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(0);
            String name = cs.getString(1);
            String password = cs.getString(2);
            lstUser.add(new User(id,name,password));
            cs.moveToNext();
        }
        cs.close();
        db.close();
        return lstUser;
    }

    public static User GetUser(Context context,String username)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cs = db.query(helper.TABLE_NAME,null,helper.COLUMN_USERNAME, new String[] {String.valueOf(username)},null,null,null);
        if(cs != null)
        {
            cs.moveToFirst();
        }

        User user = new User(cs.getInt(0),cs.getString(1),cs.getString(2));
        return  user;
    }
}
