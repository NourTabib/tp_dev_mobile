package com.example.miniappcrudsqlite;

import static com.example.miniappcrudsqlite.DatabaseHandler.DATABASE_NAME;
import static com.example.miniappcrudsqlite.DatabaseHandler.DATABASE_VERSION;
import static com.example.miniappcrudsqlite.DatabaseHandler.KEY_ID;
import static com.example.miniappcrudsqlite.DatabaseHandler.KEY_NAME;
import static com.example.miniappcrudsqlite.DatabaseHandler.KEY_NUMBER;
import static com.example.miniappcrudsqlite.DatabaseHandler.TABLE_NAME;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class ContactBDD {
    private SQLiteDatabase mdb;
    private DatabaseHandler DBcontacts;
    public ContactBDD(Context context){
        DBcontacts=new DatabaseHandler(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public SQLiteDatabase openEcriture(){
    mdb=DBcontacts.getReadableDatabase();
    return mdb;
    }
    public SQLiteDatabase openLecture(){
        mdb=DBcontacts.getWritableDatabase();
        return mdb;
    }
    public long addContact(Contact c){
        mdb=this.openEcriture();
        ContentValues v =new ContentValues();
        v.put(KEY_NAME,c.getName());
        v.put(KEY_NUMBER,c.getNum());
        long i = mdb.insert(TABLE_NAME,null,v);
        return i;
    }
    public Contact searchContact(int id){
        mdb=this.openLecture();
        String Query="Select * FROM "+TABLE_NAME+" where id=?";
        Cursor curseur=mdb.rawQuery(Query,new String[]{String.valueOf(id)});
        if(curseur.getCount()==0){
            return null;
        }
        Contact oc=new Contact();
        if(curseur.moveToFirst()){
            oc.setName(curseur.getString(1));
            oc.setNumber(curseur.getString(2));
        }
        return oc;
    }
    public List<Contact> getAllContact(){
        mdb=this.openLecture();
        List<Contact> contactList=new ArrayList<Contact>();
        String Query="Select * FROM "+TABLE_NAME;
        Cursor curseur=mdb.rawQuery(Query,null);
        if(curseur.getCount()==0){
            return null;
        }
        if(curseur.moveToFirst()){
        do{
            Contact oc=new Contact();
            oc.setId(curseur.getInt(0));
            oc.setName(curseur.getString(1));
            oc.setNumber(curseur.getString(2));
            contactList.add(oc);
        }while(curseur.moveToNext());
        }
        curseur.close();
        mdb.close();
        return contactList;
    }
    public void UpdateContact(Contact c){
        mdb=this.openEcriture();
        mdb.delete(TABLE_NAME,KEY_ID+"= ?", new String[]{String.valueOf(c.getId())});
    }
    public void deleteContact(Contact c){
        mdb=this.openEcriture();
        mdb.delete(TABLE_NAME,KEY_ID+"=?",new String[]{String.valueOf(c.getId())});
        mdb.close();
    }

}