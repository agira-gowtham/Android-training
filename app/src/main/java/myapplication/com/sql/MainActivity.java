package myapplication.com.sql;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;

    public AppCompatButton b1,b2;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        ed1 = (EditText) findViewById(R.id.editext);
        ed2 = (EditText) findViewById(R.id.editext2);
        ed3 = (EditText) findViewById(R.id.editext3);
        b1 = (AppCompatButton) findViewById(R.id.button);
        b2=(AppCompatButton) findViewById(R.id.button2);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = ed1.getText().toString();
                String ph = ed2.getText().toString();
                String e = ed3.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Name, n);
                editor.putString(Phone, ph);
                editor.putString(Email, e);
                editor.apply();
                Toast.makeText(MainActivity.this, "Thanks", Toast.LENGTH_LONG).show();

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

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
                    if (sharedpreferences.contains(Name)) {
                        ed1.setText(sharedpreferences.getString(Name, ""));
                        Toast.makeText(getApplicationContext(),"The name is"+ed1,Toast.LENGTH_LONG).show();
                    }
                    if (sharedpreferences.contains(Phone)) {
                        ed2.setText(sharedpreferences.getString(Phone, ""));
                        Toast.makeText(getApplicationContext(),"The name is"+ed2,Toast.LENGTH_LONG).show();
                    }
                    if(sharedpreferences.contains(Email)){
                        ed3.setText(sharedpreferences.getString(Email,""));
                        Toast.makeText(getApplicationContext(),"The name is"+ed3,Toast.LENGTH_LONG).show();
                    }
                }

            });
        
    }
}
