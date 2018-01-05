package com.example.a300454171.assignment6ex2kevinburnside;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String[] contacts;
    ListView lstView;
    //
    Intent intent;
    private TextView displayMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_PHONE_STATE},
                1


        );

        this.getSupportActionBar().setTitle("My Messaging App");
        //ListView lstView = getListView();
        lstView = (ListView)findViewById(R.id.android_list);
        TextView textView = new TextView(getApplicationContext());
        textView.setText("My Contacts");

        lstView.addHeaderView(textView);
        lstView.setChoiceMode(ListView.CHOICE_MODE_NONE);
        lstView.setTextFilterEnabled(true);

        contacts = getResources().getStringArray(R.array.contacts);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, contacts);
        // Assign adapter to ListView
        lstView.setAdapter(adapter);
        intent = new Intent(this, messageAct.class);
        // ListView Item Click Listener
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String item = (String) lstView.getItemAtPosition(position);

                // Show Alert
                intent.putExtra("contactName",item);
                startActivity(intent);

            }

        });


    }

}
