package com.example.listview;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Edge", "Clips", "OCR", "Tflite"};
    String mDescription[] = {"Edge Description", "Clips Description", "OCR Description", "Tflite Description"};
    int images[] = {R.drawable.edge, R.drawable.clips, R.drawable.ocr, R.drawable.tflite};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 0) {
//                    Toast.makeText(MainActivity.this, "Edge Description", Toast.LENGTH_SHORT).show();
//                }
//                if (position == 0) {
//                    Toast.makeText(MainActivity.this, "Clips Description", Toast.LENGTH_SHORT).show();
//                }
//                if (position == 0) {
//                    Toast.makeText(MainActivity.this, "OCR Description", Toast.LENGTH_SHORT).show();
//                }
//                if (position == 0) {
//                    Toast.makeText(MainActivity.this, "Tflite  Description", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImages[];

        MyAdapter(Context c, String title[],String description[], int img[]){
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImages = img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);
            Button button = row.findViewById(R.id.btn);

            myTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Text Working", Toast.LENGTH_SHORT).show();
                }
            });

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Button Working", Toast.LENGTH_SHORT).show();
                    openActivity2();
                }
            });

            // now set our resources on views
            images.setImageResource(rImages[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row;

        }
    }


    private void openActivity2() {
        Intent intent = new Intent(this, NewPage.class);
        startActivity(intent);

    }
    }