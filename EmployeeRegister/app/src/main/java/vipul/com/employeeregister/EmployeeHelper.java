package vipul.com.employeeregister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vipulshah on 1/4/15.
 */
public class EmployeeHelper {
    public static final
    String DATABASE_NAME = "emp.db";
    public static final
    String TABLE_NAME = "employee";
    public static final
    String COLUMN_ID = "_ids";
    public static final
    String COLUMN_NAME = "name";
    public static final
    String COLUMN_LOCATION = "location";
    public static final
    String COLUMN_ORGANISATION = "organisation";
    public static final
    int DATABASE_VERSION = 1;
    private EmployeeDBHelper dbHelper;
    private SQLiteDatabase liteDatabase;
    private Context mContext;

    private static final String TABLE_CREATION_QUERY =
            "create table " + TABLE_NAME +
                    "(" + COLUMN_ID + " integer primary key autoincrement ," +
                    COLUMN_NAME + " text , " +
                    COLUMN_LOCATION + " text ," +
                    COLUMN_ORGANISATION + " text);";

    public EmployeeHelper(Context context) {
        dbHelper = new EmployeeDBHelper
                (context);
        this.mContext = context;
    }

    public void open() {
        liteDatabase = dbHelper.getWritableDatabase();
    }

    public void close() {
        liteDatabase.close();
    }

    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();

        Cursor cursor = liteDatabase.query
                (TABLE_NAME, null, null,
                        null, null, null, null);

        if (cursor != null &&
                cursor.moveToFirst()) {
            do {
                String name = cursor.
                        getString(
                                cursor.
                                        getColumnIndex(COLUMN_NAME));
                String location = cursor.
                        getString(
                                cursor.
                                        getColumnIndex(COLUMN_LOCATION));
                String organisation = cursor.
                        getString(
                                cursor.
                                        getColumnIndex(COLUMN_ORGANISATION));
                Employee employee = new Employee();
                employee.name = name;
                employee.location = location;
                employee.organisation = organisation;
                employees.add(employee);

            } while (cursor.moveToNext());
        }

        return employees;
    }

    public void addEmployee
            (Employee emp) {
        ContentValues values = new
                ContentValues();
        values.put(COLUMN_NAME, emp.name);
        values.put(COLUMN_LOCATION,
                emp.location);
        values.put(COLUMN_ORGANISATION,
                emp.organisation);

        long rowID = liteDatabase.insert
                (TABLE_NAME, null, values);

        if (rowID != -1) {
            Toast.makeText(mContext, "Success!",
                    Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(mContext, "Failure!",
                    Toast.LENGTH_LONG).show();
        }

    }

    public void deleteEmployee(String name) {
        int numRowsDeleted = liteDatabase.delete
                (TABLE_NAME, COLUMN_NAME + "=?",
                        new String[]{name});

        Toast.makeText(mContext, numRowsDeleted + " rows deleted",
                Toast.LENGTH_LONG).show();
    }

    public void updateEmployee(String name, String newLocation,
                               String newOrganisation) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_LOCATION, newLocation);
        values.put(COLUMN_ORGANISATION, newOrganisation);
        liteDatabase.update(TABLE_NAME, values,
                COLUMN_NAME + "=?",
                new String[]{name});
    }


    private class EmployeeDBHelper extends
            SQLiteOpenHelper {

        public EmployeeDBHelper(Context context) {
            super(context, DATABASE_NAME, null,
                    DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TABLE_CREATION_QUERY);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
