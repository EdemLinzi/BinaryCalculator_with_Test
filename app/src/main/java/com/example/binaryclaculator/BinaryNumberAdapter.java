package com.example.binaryclaculator;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class BinaryNumberAdapter extends BaseAdapter {

    private ArrayList<String> datas;
    private Context myContext;
    ArrayList<TextView> textViews;

    public BinaryNumberAdapter(Context context, ArrayList<String> datas,ArrayList<TextView> textViews){
        this.myContext = context;
        this.datas = datas;
        this.textViews = textViews;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = View.inflate(myContext,R.layout.list_item,null);

        final TextView textView = textViews.get(position);
        Button btn_add0 = view.findViewById(R.id.button_0);
        Button btn_add1 = view.findViewById(R.id.button_1);
        Button btn_delete = view.findViewById(R.id.button_delete);
        Button btn_clear = view.findViewById(R.id.button_clear);

        btn_add0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("BinaryNumberAdapter","add0");
                textView.setText(textView.getText().toString()+"0");
                datas.set(position,textView.getText().toString());

            }
        });

        btn_add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("BinaryNumberAdapter","add1");
                textView.setText(textView.getText().toString()+"1");
                datas.set(position,textView.getText().toString());

            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("BinaryNumberAdapter","deleteLastChar");
                String str = textView.getText().toString();
                if(str.length() != 0) {
                    str = str.substring(0, str.length() - 1);
                    textView.setText(str);
                    datas.set(position,str);
                }
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("BinaryNumberAdapter","clearText");
                textView.setText("");
                datas.set(position,textView.getText().toString());

            }
        });

        return view;
    }

}
