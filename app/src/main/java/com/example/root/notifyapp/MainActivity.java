package com.example.root.notifyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    private static Button show_text,got;
    private static TextView clipboardData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        //show_text = (Button) findViewById(R.id.show_text);//

        got = (Button) findViewById(R.id.button);

        //clipboardData = (TextView) findViewById(R.id.clipboard_data);//

        Intent intent = new Intent(MainActivity.this,TheService.class);

        startService(intent);

        got.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent ii = new Intent(MainActivity.this,BackgroundActivity.class);
                startActivity(ii);
            }
        });



        //showData();//


    }





   /* public void showData( ){

        show_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res = myDb.getAllData();

                if(res.getCount()==0)
                {
                    showMessage("Error","Nothing Found");
                    return;
                }

                StringBuffer stringBuffer =new StringBuffer();

                while(res.moveToNext()){

                    stringBuffer.append("Link : "+ res.getString(1)+"\n\n\n");

                }

                showMessage("Data",stringBuffer.toString());
            }
        });

    }*/



   /* public void showMessage(String title,String message){

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.show();



    }*/




}