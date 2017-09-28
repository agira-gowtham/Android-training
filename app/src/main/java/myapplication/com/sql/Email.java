package myapplication.com.sql;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

public class Email extends AppCompatActivity implements View.OnClickListener {
    private TextInputEditText mid,sub,msg;
    private  AppCompatButton send,nxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        init();
    }
    public void init(){

        //Id Declaration
        mid=(TextInputEditText)findViewById(R.id.mid);
        sub=(TextInputEditText)findViewById(R.id.sub);
        msg=(TextInputEditText)findViewById(R.id.msg);
        send=(AppCompatButton)findViewById(R.id.send);
        nxt=(AppCompatButton)findViewById(R.id.nxt);

        //ONclick send button event
        send.setOnClickListener(this);
        nxt.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view==send) {
            String mailid = mid.getText().toString();
            String subject = sub.getText().toString();
            String message = msg.getText().toString();
            Intent emailApp = new Intent(Intent.ACTION_SEND);
            emailApp.putExtra(Intent.EXTRA_EMAIL, new String[]{mailid});
            emailApp.putExtra(Intent.EXTRA_SUBJECT, subject);
            emailApp.putExtra(Intent.EXTRA_TEXT, message);
            emailApp.setType("message/rfc822");
            startActivity(Intent.createChooser(emailApp, "Send Email Via"));

        }
        else if(view==nxt){
            Intent intent=new Intent(getApplicationContext(),Webv.class);
            startActivity(intent);
        }
    }
}
