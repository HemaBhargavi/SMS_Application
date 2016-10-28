package com.example.hema.sms_app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {
    Button Butt;
    Button Button2;
    EditText num;
    EditText message;
    SmsReceiver receiver=new SmsReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         Butt=(Button)findViewById(R.id.button);
        Button2=(Button)findViewById(R.id.button2);
         num=(EditText)findViewById(R.id.editText);
         message=(EditText)findViewById(R.id.editText2);
        Butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageSender();
            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           //receiver.onReceive(this,);
                                       }
                                   }

        );

    }
    public void messageSender(){
        String number= num.getText().toString();
        String messageText= message.getText().toString();
     if(number.length()==10&&((number.charAt(0)=='9')||(number.charAt(0)=='8')||(number.charAt(0)=='7'))) {
            SmsManager sms = SmsManager.getDefault();

            sms.sendTextMessage(number, null, messageText, null, null);
     }
        else{
            Toast.makeText(SMSActivity.this,"Enter a valid number",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void updateList(String smsMessageStr) {
//    }
//
//    public static SMSActivity instance() {
//    }
}
