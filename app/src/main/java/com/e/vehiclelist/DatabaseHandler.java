package com.e.vehiclelist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public class DatabaseHandler extends SQLiteOpenHelper {
        Context context;
        private static String DATABASE_NAME="mydb.db";
        private static int DATABASE_VERSION=1;
    private static String createTableQuery="create table imageInfo (vehicleType TEXT,vehicleNumber TEXT,vehicleCompany TEXT,vehicleDescription TEXT,image BLOB)";
    private ByteArrayOutputStream byteArrayOutputStream;
    private byte[] imageinbyte;
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTableQuery);
        Toast.makeText(context, "Details Uploaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void storeImage(ModelClass modelClass){
        SQLiteDatabase objectsqlitedatabase=this.getWritableDatabase();
        Bitmap imagetostorebitmap=modelClass.getImage();
        byteArrayOutputStream=new ByteArrayOutputStream();
        imagetostorebitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        imageinbyte=byteArrayOutputStream.toByteArray();
        ContentValues contentValues=new ContentValues();
        contentValues.put("vehicleType",modelClass.getVehicletypeMC());
        contentValues.put("vehicleNumber",modelClass.getVehicleNumberMC());
        contentValues.put("vehicleCompany",modelClass.getVehiclecompanyMC());
        contentValues.put("vehicleDescription",modelClass.getVehicledescriptionMC());
        contentValues.put("image",imageinbyte);
        long check=objectsqlitedatabase.insert("imageInfo",null,contentValues);
        if(check!=-1){
            Toast.makeText(context, "Details Uploaded", Toast.LENGTH_SHORT).show();
            objectsqlitedatabase.close();
        }
        else{
            Toast.makeText(context, "Failed to upload image", Toast.LENGTH_SHORT).show();
        }
    }
        public ArrayList<ModelClass> getallImagesData(){

            SQLiteDatabase objectSQliteDatabase=this.getReadableDatabase();
            ArrayList<ModelClass> objectModelClassList=new ArrayList<>();
            Cursor objectCursor=objectSQliteDatabase.rawQuery("select*from imageInfo",null);
            if(objectCursor.getCount()!=0){
                while(objectCursor.moveToNext()){
                    String vType=objectCursor.getString(0);
                    String vNumber=objectCursor.getString(1);
                    String vCompany=objectCursor.getString(2);
                    String vDescription=objectCursor.getString(3);
                    byte[] imageBytes=objectCursor.getBlob(4);
                    Bitmap objectBitmap= BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.length);
                    objectModelClassList.add(new ModelClass(vType,vNumber,vCompany,vDescription,objectBitmap));

                }
                return objectModelClassList;

            }
            else{
                Toast.makeText(context, "No Details Uploaded Yet", Toast.LENGTH_SHORT).show();
                return null;
            }
        }






















}
