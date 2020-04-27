package com.example.list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Button button;
    ExpandableListView expandableListView;

    List<String> langs;
    Map<String, List<String>> topics;
    ExpandableListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        fillData();

        listAdapter = new ExListAdapter(this, langs, topics);

        expandableListView.setAdapter(listAdapter);
    }
    public void fillData() {
        langs = new ArrayList<>();
        topics = new HashMap<>();

        langs.add("Swedish");
        langs.add("English");
        langs.add("Danish");
        langs.add("Spanish");

        List<String> swedish = new ArrayList<>();
        List<String> english = new ArrayList<>();
        List<String> danish = new ArrayList<>();
        List<String> spanish = new ArrayList<>();

        swedish.add("hej");
        swedish.add("på");
        swedish.add("dig");

        english.add("yes");
        english.add("hello");
        english.add("world");

        danish.add("Mads");
        danish.add("Skidderöv");

        spanish.add("hola");

        topics.put(langs.get(0),swedish);
        topics.put(langs.get(1),english);
        topics.put(langs.get(2),danish);
        topics.put(langs.get(3),spanish);



        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }
    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

}
