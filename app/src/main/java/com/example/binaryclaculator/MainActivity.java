package com.example.binaryclaculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> datas = new ArrayList<String>(){{
        add("");
        add("");
    }};

    ArrayList<TextView> textViews;

    BinaryNumberAdapter binaryNumberAdapter;
    BinaryNumberCalculator binaryNumberCalculator;

    ListView listView;
    Button btnaddTwoNumber;
    Button btnsubstractTwoNumber;
    TextView textViewresult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "onCreate ");

        textViews = new ArrayList<TextView>(){{
            add((TextView) findViewById(R.id.textViewFirst));
            add((TextView) findViewById(R.id.textViewSecond));
        }};


        textViews.get(0).setText(datas.get(0));
        textViews.get(1).setText(datas.get(1));

        binaryNumberAdapter = new BinaryNumberAdapter(this,datas,textViews);
        binaryNumberCalculator = new BinaryNumberCalculator();

        listView = findViewById(R.id.list_view);
        listView.setAdapter(binaryNumberAdapter);

        btnaddTwoNumber = findViewById(R.id.button_add);
        btnsubstractTwoNumber = findViewById(R.id.button_substract);

        textViewresult = findViewById(R.id.textView_result);
        textViewresult.setText("Result");


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("FirstTV",textViews.get(0).getText().toString());
        outState.putString("SecondTV",textViews.get(1).getText().toString());
        outState.putString("ResultTV",textViewresult.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String tmp = savedInstanceState.getString("FirstTV");
        textViews.get(0).setText(tmp);
        datas.set(0,tmp);
        tmp = savedInstanceState.getString("SecondTV");
        textViews.get(1).setText(tmp);
        datas.set(1,tmp);
        tmp = savedInstanceState.getString("ResultTV");
        textViewresult.setText(tmp);
    }

    public void add(View v){
        binaryNumberAdapter.notifyDataSetChanged();
        if(!datas.get(0).equals("") && !datas.get(1).equals("")) {
            Log.i("MainActivity", "add " + datas.get(0) + " " + datas.get(1));

            int a = Integer.parseInt(datas.get(0),2);
            int b = Integer.parseInt(datas.get(1),2);
            String result = binaryNumberCalculator.add(a,b);
            textViewresult.setText(result);
        }
    }

    public void substract(View v){
        binaryNumberAdapter.notifyDataSetChanged();
        if(!datas.get(0).equals("") && !datas.get(1).equals("")) {
            Log.i("MainActivity", "substarct " + datas.get(0) + " " + datas.get(1));

            int a = Integer.parseInt(datas.get(0),2);
            int b = Integer.parseInt(datas.get(1),2);
            String result = binaryNumberCalculator.substract(a,b);
            textViewresult.setText(result);
        }
    }


}
