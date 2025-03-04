package com.example.triviab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    // יצירת משתנים עבור הספינר והכפתור
    private Spinner spinner;
    private String[] arrColor = { "Red", "Blue", "Pink", "Yellow"};  // מערך צבעים
    private Button btnChooseColor;
    private String chooseColor;  // משתנה לשמירת הצבע שנבחר

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);  // קביעת ה-layout של הפעילות

        // אתחול הספינר
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);  // הגדרת מאזין לבחירת פריט בספינר

        // אתחול הכפתור
        btnChooseColor = findViewById(R.id.btnChooseColor);
        btnChooseColor.setOnClickListener(this);  // הגדרת מאזין לכפתור

        // יצירת ArrayAdapter להצגת הצבעים בספינר
        ArrayAdapter aa =
                new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrColor);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  // קביעת עיצוב התפריט הנפתח
        spinner.setAdapter(aa);  // הגדרת ה-Adapter לספינר
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        chooseColor = arrColor[position];  // שמירת הצבע שנבחר על ידי המשתמש
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // מתבצע אם לא נבחר פריט (לרוב לא יהיה שימוש כאן)
    }

    @Override
    public void onClick(View v) {
        // יצירת אינטנט להעברת הצבע הנבחר לפעילות אחרת
        Intent i = new Intent();
        i.putExtra("color", chooseColor);  // הוספת הצבע הנבחר לאינטנט
        setResult(RESULT_OK, i);  // קביעת תוצאת הפעילות והחזרת האינטנט
        finish();  // סגירת הפעילות הנוכחית
    }
}
