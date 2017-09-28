package myapplication.com.sql.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;

import myapplication.com.sql.Email;
import myapplication.com.sql.Model.Countries;
import myapplication.com.sql.Model.MyPojo;
import myapplication.com.sql.R;
import myapplication.com.sql.adapter.AlbumsAdapter;
import myapplication.com.sql.volley.VolleyTasks;
import myapplication.com.sql.volley.VolleyTasksListener;

public class JSONActivity extends AppCompatActivity implements VolleyTasksListener,View.OnClickListener{

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private AppCompatButton nxt;

    //private ArrayList<ImageList> imageLists;

    private ArrayList<Countries> Countries;
    private AlbumsAdapter adapter;

    String Url="http://wptrafficanalyzer.in/p/demo1/first.php/countries/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        recyclerView=(RecyclerView)findViewById(R.id.recycle1);
        nxt=(AppCompatButton)findViewById(R.id.nxt);
        nxt.setOnClickListener(this);
        VolleyTasks.makeVolleyGETObject(this,Url,"product");

    }

    @Override
    public void handleResult(String method_name, JSONObject response) {

        if (response!= null) if (method_name.equals("product")) {
            GsonBuilder gsonbulder = new GsonBuilder();

            Gson gson = gsonbulder.create();

            MyPojo place_list = gson.fromJson(response.toString(), MyPojo.class);

            Countries = place_list.getCountries();



            adapter = new AlbumsAdapter(this,Countries);

            mLayoutManager = new LinearLayoutManager(getApplicationContext());

            recyclerView.setLayoutManager(mLayoutManager);// Here 2 is no. of columns to be displayed

            recyclerView.setAdapter(adapter);

        }

    }

    @Override
    public void handleError(VolleyError e) {
    }

    @Override
    public void onClick(View view) {
        if(view==nxt){
            Intent intent=new Intent(getApplicationContext(), Email.class);
            startActivity(intent);
        }

    }
}
