package com.example.triviab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Instructions extends AppCompatActivity {
    private TextView tv7 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
         tv7=findViewById(R.id.tv7);
         tv7.setText("הוראות: משחק שאלות טריויה , יופיעו לפניך שאלות שלכל שאלה 4 תשובות אפשריות עליך לבחור את התשובה הנכונה (:");


    }
}