package myapplication.com.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private EditText name;
    private EditText phone;
    private MyHelper MyHelper1;
    private SQLiteDatabase SQliteDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name=(EditText)findViewById(R.id.name);
        phone=(EditText)findViewById(R.id.surn);
        MyHelper1=new MyHelper(Main2Activity.this,"STUDB",null,1);
        SQliteDb=MyHelper1.getWritableDatabase();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void insertData(View view){
        ContentValues cv=new ContentValues();
        cv.put("name",name.getText().toString());
        cv.put("phone",phone.getText().toString());
        long id=SQliteDb.insert("student",null,cv);
        Toast.makeText(Main2Activity.this,String.valueOf(id),Toast.LENGTH_LONG).show();
    }
    public void readData(View view){

        Cursor c=SQliteDb.query("student",null,null,null,null,null,null);
        while (c.moveToNext()){
            Toast.makeText(Main2Activity.this,c.getString(c.getColumnIndex("name")),Toast.LENGTH_LONG).show();
        }
    }

}
