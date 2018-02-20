package com.example.android.waitlist.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WaitlistDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "waitlist.db";
    private static final int DATABASE_VERSION = 1;

    public WaitlistDbHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + WaitlistContract.WaitlistEntry.TABLE_NAME +
                                    " ( " + WaitlistContract.WaitlistEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                            WaitlistContract.WaitlistEntry.COLUMN_GUEST_NAME +  " TEXT NOT NULL, " +
                                            WaitlistContract.WaitlistEntry.COLUMN_PARTY_SIZE + " INTEGER NOT NULL, " +
                                            WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                                    + " ); ";

        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WaitlistContract.WaitlistEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

}