package com.example.root.notifyapp;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.Toast;

public class HelperActivity extends Activity {

    private HelperActivity ctx;

    DatabaseHelper myDb;

    String action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        ctx=this;
        setContentView(R.layout.coustomnotification);
        NotificationManager notificationmanager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // Dismiss Notification
        notificationmanager.cancel(0);
        Toast.makeText(getBaseContext(),"I'm in onCreate!!!",Toast.LENGTH_LONG).show();



             /*SharedPreferences sp = getSharedPreferences("prev", Activity.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sp.edit();
        String prevs=sp.getString("prev","");*/


        String text = Clipboard_Utils.getDataFromClipboard(HelperActivity.this);
        String[] text1 = text.split(":");

       /* if(!text.equals(prevs)) {

            editor.putString("prev",text);

            editor.apply();*/

        if (!text.equals("")) {

            if (text1[0].equals("http") || text1[0].equals("https")) {


                boolean isInserted = myDb.insertData(text);


                if (isInserted == true) {

                    Toast.makeText(HelperActivity.this, "Data Inserted ", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(HelperActivity.this, "Not a legal link", Toast.LENGTH_SHORT).show();


                }


            } else
                Toast.makeText(HelperActivity.this, "Clipboard is empty.", Toast.LENGTH_SHORT).show();

        }

        /*Intent i = getIntent();
        action = i.getStringExtra("title");


        if(action.equals("1")){


        }*/

    }
}

