package info.codestart.glinogaprdrecrds;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

import info.codestart.glinogaprdrecrds.Person;

/**
 * Created by Ronsoft on 9/16/2017.
 */

public class PersonDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "people.db";
    private static final int DATABASE_VERSION = 3 ;
    public static final String TABLE_NAME = "People";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PERSON_NAME = "name";
    public static final String COLUMN_PERSON_AGE = "age";
    public static final String COLUMN_PERSON_DATE = "date";
    public static final String COLUMN_PERSON_ADDRESS = "address";
    public static final String COLUMN_PERSON_NUMBER = "number";
    public static final String COLUMN_PERSON_LEFT = "lft";
    public static final String COLUMN_PERSON_RIGHT = "rght";
    public static final String COLUMN_PERSON_PAYMENT = "payment";
    public static final String COLUMN_PERSON_EYE = "eye";
    public static final String COLUMN_PERSON_PAPER = "paper";
    public static final String COLUMN_PERSON_FINDINGS = "findings";
    public static final String COLUMN_PERSON_ADDITIONAL = "additional";
    public static final String COLUMN_PERSON_MANAGEMENT = "management";
    public static final String COLUMN_PERSON_CH = "casehistory";
    public static final String COLUMN_PERSON_CC = "chiefcomplaint";
    public static final String COLUMN_PERSON_DGNS = "diagnosis";

    public PersonDBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PERSON_NAME + " TEXT NOT NULL, " +
                COLUMN_PERSON_AGE + " NUMBER NOT NULL, " + COLUMN_PERSON_DATE + " TEXT NOT NULL, " +
                COLUMN_PERSON_ADDRESS + " TEXT NOT NULL, " + COLUMN_PERSON_NUMBER + " NUMBER NOT NULL, " +
                COLUMN_PERSON_LEFT + " TEXT NOT NULL, " + COLUMN_PERSON_RIGHT + " TEXT NOT NULL, " + COLUMN_PERSON_EYE + " TEXT NOT NULL, "+ COLUMN_PERSON_PAPER + " TEXT NOT NULL, " + COLUMN_PERSON_FINDINGS + " TEXT NOT NULL, " + COLUMN_PERSON_ADDITIONAL + " TEXT NOT NULL, " + COLUMN_PERSON_MANAGEMENT + " TEXT NOT NULL, " + COLUMN_PERSON_CH + " TEXT NOT NULL, " + COLUMN_PERSON_CC + " TEXT NOT NULL, " + COLUMN_PERSON_DGNS + " TEXT NOT NULL, " +
                COLUMN_PERSON_PAYMENT + " TEXT NOT NULL);"
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // you can implement here migration process
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        this.onCreate(db);
    }
    /**create record**/
    public void saveNewPerson(Person person) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PERSON_NAME, person.getName());
        values.put(COLUMN_PERSON_AGE, person.getAge());
        values.put(COLUMN_PERSON_DATE, person.getDate());
        values.put(COLUMN_PERSON_ADDRESS, person.getAddress());
        values.put(COLUMN_PERSON_NUMBER, person.getContactnumber());
        values.put(COLUMN_PERSON_LEFT, person.getLefteyegrade());
        values.put(COLUMN_PERSON_RIGHT, person.getRighteyegrade());
        values.put(COLUMN_PERSON_EYE, person.getAOD());
        values.put(COLUMN_PERSON_PAPER, person.getOldRX());
        values.put(COLUMN_PERSON_FINDINGS, person.getSpecialfindings());
        values.put(COLUMN_PERSON_ADDITIONAL, person.getAdditionaltest());
        values.put(COLUMN_PERSON_MANAGEMENT, person.getManagement());
        values.put(COLUMN_PERSON_CH, person.getCasehistory());
        values.put(COLUMN_PERSON_CC, person.getChiefcomplaint());
        values.put(COLUMN_PERSON_DGNS, person.getDiagnosis());
        values.put(COLUMN_PERSON_PAYMENT, person.getPayment());

        // insert
        db.insert(TABLE_NAME,null, values);
        db.close();
    }

    /**Query records, give options to filter results**/
    public List<Person> peopleList(String filter) {
        String query;
        if(filter.equals("")){
            //regular query
            query = "SELECT  * FROM " + TABLE_NAME;
        }else{
            //filter results by filter option provided
            query = "SELECT  * FROM " + TABLE_NAME + " ORDER BY "+ filter;
        }

        List<Person> personLinkedList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Person person;

        if (cursor.moveToFirst()) {
            do {
                person = new Person();

                person.setId(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)));
                person.setName(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_NAME)));
                person.setAge(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_AGE)));
                person.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_DATE)));

                personLinkedList.add(person);
            } while (cursor.moveToNext());
        }


        return personLinkedList;
    }

    /**Query only 1 record**/
    public Person getPerson(long id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT  * FROM " + TABLE_NAME + " WHERE _id="+ id;
        Cursor cursor = db.rawQuery(query, null);

        Person receivedPerson = new Person();
        if(cursor.getCount() > 0) {
            cursor.moveToFirst();

            receivedPerson.setName(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_NAME)));
            receivedPerson.setAge(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_AGE)));
            receivedPerson.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_DATE)));
            receivedPerson.setAddress(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_ADDRESS)));
            receivedPerson.setContactnumber(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_NUMBER)));
            receivedPerson.setLefteyegrade(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_LEFT)));
            receivedPerson.setRighteyegrade(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_RIGHT)));
            receivedPerson.setAOD(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_EYE)));
            receivedPerson.setOldRX(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_PAPER)));
            receivedPerson.setSpecialfindings(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_FINDINGS)));
            receivedPerson.setAdditionaltest(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_ADDITIONAL)));
            receivedPerson.setManagement(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_MANAGEMENT)));
            receivedPerson.setCasehistory((cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_CH))));
            receivedPerson.setChiefcomplaint(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_CC)));
            receivedPerson.setDiagnosis(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_DGNS)));
            receivedPerson.setPayment(cursor.getString(cursor.getColumnIndex(COLUMN_PERSON_PAYMENT)));


        }
        return receivedPerson;
    }


    /**delete record**/
    public void deletePersonRecord(long id, Context context) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE _id='"+id+"'");
        Toast.makeText(context, "Deleted successfully.", Toast.LENGTH_SHORT).show();

    }

    /**update record**/
    public void updatePersonRecord(long personId, Context context, Person updatedperson) {
        SQLiteDatabase db = this.getWritableDatabase();
        //you can use the constants above instead of typing the column names

        db.execSQL("UPDATE  "+TABLE_NAME+" SET name ='"+ updatedperson.getName() + "', age ='" + updatedperson.getAge() + "', date = '" + updatedperson.getDate() + "', address = '" + updatedperson.getAddress() + "' , number = '" + updatedperson.getContactnumber() + "', lft = '" + updatedperson.getLefteyegrade() + "', rght = '" + updatedperson.getRighteyegrade() +  "', eye = ' " + updatedperson.getAOD() + "', paper = '" + updatedperson.getOldRX() + "', findings = '" + updatedperson.getSpecialfindings() + "' , additional = '" + updatedperson.getAdditionaltest() + "' , management = '" + updatedperson.getManagement() + "' , casehistory = '" + updatedperson.getCasehistory() + "' , chiefcomplaint = '" + updatedperson.getChiefcomplaint() + "' , diagnosis = '" + updatedperson.getDiagnosis() + "', payment = '" + updatedperson.getPayment() + "'  WHERE _id='" + personId + "'");
        Toast.makeText(context, "Updated successfully.", Toast.LENGTH_SHORT).show();


    }




}
