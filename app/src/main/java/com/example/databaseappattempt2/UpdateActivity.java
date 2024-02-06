package com.example.databaseappattempt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText title_input, author_input, pages_input;
    Button update_button;

    String id, title, author, pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

    title_input = findViewById(R.id.title_input2);
    author_input = findViewById(R.id.author_input2);
    pages_input = findViewById(R.id.pages_input2);

    update_button = findViewById(R.id.update_button);

        //Call this first
        getAndSetIntentData();

    update_button.setOnClickListener(view -> {

    //And then we can call this
    MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
    myDB.updateData(id, title, author, pages);
    Toast.makeText(UpdateActivity.this,"Meow", Toast.LENGTH_SHORT).show();
    });
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") && getIntent().hasExtra("author") && getIntent().hasExtra("pages")){
            //Getting data from intent
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            author = getIntent().getStringExtra("author");
            pages = getIntent().getStringExtra("pages");

            //Setting intent data
            title_input.setText(title);
            author_input.setText(author);
            pages_input.setText(pages);

            //Toast.makeText(this,"Data Updated", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"No data", Toast.LENGTH_SHORT).show();
        }
    }
}