package com.gmail.donncha.assignment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by donncha on 11/22/2015.
 */
public class DebateList extends AppCompatActivity implements View.OnClickListener {

    Button bBack;
    String data;
    ArrayList<String> exList = new ArrayList<>();
    DatabaseHelper helper = new DatabaseHelper(this);

    protected void onCreate(Bundle savedInstanceState) {

        ArrayList<String> question = new ArrayList<String>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debatelist);

        bBack = (Button) findViewById(R.id.bBack);
        ListView listview = (ListView) findViewById(R.id.listDebate);

        bBack.setOnClickListener(this);
        //listview.setOnClickListener(this);

        question = helper.queryColumn();

        ArrayAdapter<String> myArrayAdapter =  new ArrayAdapter(this, android.R.layout.simple_list_item_1, question);
        listview.setAdapter(myArrayAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bBack:
                String username = getIntent().getStringExtra("Username");
                Intent i = new Intent(DebateList.this, Menu.class);
                i.putExtra("Username", username);
                startActivity(i);

                //startActivity(new Intent(DebateList.this, Menu.class));
                break;

        }
    }
}
