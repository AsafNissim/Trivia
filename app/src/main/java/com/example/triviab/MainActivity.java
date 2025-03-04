package com.example.triviab;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    // משתנים
    private ActivityResultLauncher<Intent> launcher;  // משתנה לאתחול הפעילות המתקבלת
    private FbModule fbModule;  // מודול העבודה עם Firebase
    private String backgroundColor = "";  // משתנה לאחסון הצבע הנבחר לרקע
    private ConstraintLayout ll;  // המשתנה שמייצג את הלAYOUT (לממשק עם הרקע)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // קביעת ה-layout של הפעילות
        ll = findViewById(R.id.main);  // אתחול ה-ConstraintLayout שבו נמצא הרקע

        fbModule = new FbModule(this);  // אתחול מודול ה-Firebase

        // אתחול ה-ActivityResultLauncher לניהול תוצאות פעילויות
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),  // הגדרת חוזה לתוצאה
                new ActivityResultCallback<ActivityResult>() {  // הגדרת מאזין לתוצאה
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        // בדיקה אם הפעילות הסתיימה בהצלחה
                        if (o.getResultCode() == RESULT_OK) {
                            Intent data = o.getData();
                            String str = data.getStringExtra("color");  // קבלת הצבע שנבחר
                            fbModule.writeBackgroundColorToFb(str);  // שמירת הצבע ב-Firebase
                            //Toast.makeText(MainActivity.this, "" + str, Toast.LENGTH_SHORT).show();  // הצגת הצבע הנבחר בטוסט (מופעל אם צריך)
                        }
                    }
                }
        );
    }

    // פונקציה להתחלת משחק
    public void onStartGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("color2",this.backgroundColor);
        // יצירת אינטנט לפעילות המשחק
        startActivity(intent);  // התחלת המשחק
    }

    // פונקציה לפתיחת מסך ההגדרות
    public void onSetting(View view) {
        Intent i = new Intent(this, SettingActivity.class);  // יצירת אינטנט לפעילות ההגדרות
        launcher.launch(i);  // הפעלת פעילות ההגדרות באמצעות ActivityResultLauncher
    }

    // פונקציה להוראות (כרגע לא ממומשת)
    public void onInstruction(View view) {
        Intent intent = new Intent(this, Instructions.class);
        startActivity(intent);
    }

    // פונקציה המעדכנת את הצבע החדש שנשמר ב-Firebase
    public void setNewColorFromFb(String str) {
        this.backgroundColor = str;  // עדכון הצבע הנבחר
        //Toast.makeText(this, ""+backgroundColor, Toast.LENGTH_SHORT).show();  // הצגת הצבע הנבחר בטוסט (מופעל אם צריך)
        setBackgroundColor(str);  // עדכון הרקע לצבע החדש
    }

    // פונקציה שמעדכנת את הרקע על פי הצבע שנבחר
    public void setBackgroundColor(String color) {
        switch (color) {
            case "Red":
                ll.setBackgroundColor(Color.RED);  // צבע אדום
                break;
            case "Blue":
                ll.setBackgroundColor(Color.BLUE);  // צבע כחול
                break;
            case "Pink":
                ll.setBackgroundColor(Color.argb(255, 255, 105, 180));  // צבע ורוד
                break;
            case "Yellow":
                ll.setBackgroundColor(Color.YELLOW);  // צבע צהוב
                break;
            default:
                ll.setBackgroundColor(Color.WHITE);  // ברירת מחדל: צבע לבן
        }
    }
}
