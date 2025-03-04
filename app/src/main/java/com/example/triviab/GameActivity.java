package com.example.triviab;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    // יצירת משתנים עבור כפתורים, טקסטים ומשתנים נוספים
    private Button btna1, btna2, btna3, btna4;
    private TextView tvQuestion;
    private TextView tvQuestionNumber, tvPoints, tvGameOver;
    private Collection2 collection;  // אובייקט לאחסון שאלות
    private Question currentQuestion;  // השאלה הנוכחית
    private int points = 0;  // משתנה לאחסון ניקוד המשחק
    private LinearLayout l2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);  // הגדרת ה-layout של הפעילות

        // אתחול אובייקט ה-Collection (אחסון השאלות)
        collection = new Collection2();

        // אתחול רכיבי UI
        tvQuestion = findViewById(R.id.tvQuestion);
        btna1 = findViewById(R.id.btna1);
        btna2 = findViewById(R.id.btna2);
        btna3 = findViewById(R.id.btna3);
        btna4 = findViewById(R.id.btna4);

        // קביעת מאזינים לכפתורים
        btna1.setOnClickListener(this);
        btna2.setOnClickListener(this);
        btna3.setOnClickListener(this);
        btna4.setOnClickListener(this);

        // אתחול רכיבי טקסט נוספים
        tvPoints = findViewById(R.id.tvPoints);
        tvQuestionNumber = findViewById(R.id.tvQuestionNumber);
        tvGameOver = findViewById(R.id.tvGameOver);
        l2 = findViewById(R.id.activity_game);

        // בהתחלה, לא מוצגים את טקסט הסיום
        tvGameOver.setVisibility(View.INVISIBLE);
        Intent intent = getIntent();
        String color2 = intent.getStringExtra("color2");
        setBackgroundColorgame(color2);

        // אתחול השאלות
        collection.initQuestions();

        // הצגת השאלה הראשונה
        nextQuestion();
    }

    // פונקציה שמביאה את השאלה הבאה
    private void nextQuestion() {
        // אם יש שאלות נוספות
        if (collection.isNotLastQuestion()) {
            currentQuestion = collection.getNextQuestion();  // שליפת השאלה הבאה
            tvQuestion.setText(currentQuestion.getQuestion());  // הצגת השאלה

            // הצגת התשובות על כפתורים
            btna1.setText(currentQuestion.getA1());
            btna2.setText(currentQuestion.getA2());
            btna3.setText(currentQuestion.getA3());
            btna4.setText(currentQuestion.getA4());
        } else {
            // אם אין שאלות נוספות, הצגת סיום המשחק
            tvGameOver.setVisibility(View.VISIBLE);

            // הצגת דיאלוג מותאם אישית עם סיום המשחק
            CustomDialog customDialog = new CustomDialog(this);
            customDialog.show();
        }
    }

    // פונקציה שמטפלת בלחיצה על כפתור תשובה
    @Override
    public void onClick(View v) {
        // בדיקה איזו תשובה נבחרה
        if (v == btna1) {
            if (currentQuestion.getCorrect() == 1)  // אם התשובה הנכונה היא 1
                points++;
        }
        if (v == btna2) {
            if (currentQuestion.getCorrect() == 2)  // אם התשובה הנכונה היא 2
                points++;
        }
        if (v == btna3) {
            if (currentQuestion.getCorrect() == 3)  // אם התשובה הנכונה היא 3
                points++;
        }
        if (v == btna4) {
            if (currentQuestion.getCorrect() == 4)  // אם התשובה הנכונה היא 4
                points++;
        }

        // עדכון הניקוד המוצג
        tvPoints.setText("points: " + points);

        // הצגת מספר השאלה הנוכחית
        if (collection.isNotLastQuestion()) {
            tvQuestionNumber.setText("Question number: " + (collection.getIndex() + 1));
        }

        // הצגת השאלה הבאה
        nextQuestion();
    }

    // פונקציה לאיפוס המשחק
    public void reset() {
        this.points = 0;  // אפס את הניקוד
        collection.initQuestions();  // אתחול השאלות מחדש
        tvPoints.setText("Points: " + 0);  // הצגת הניקוד כ-0
        tvQuestionNumber.setText("Question number: " + 1);  // הצגת מספר השאלה כ-1
        tvGameOver.setVisibility(View.INVISIBLE);  // הסתרת סיום המשחק
        this.nextQuestion();  // הצגת השאלה הראשונה מחדש
    }

    public void setBackgroundColorgame(String color) {
        switch (color) {
            case "Red":
                l2.setBackgroundColor(Color.RED);  // צבע אדום
                break;
            case "Blue":
                l2.setBackgroundColor(Color.BLUE);  // צבע כחול
                break;
            case "Pink":
                l2.setBackgroundColor(Color.argb(255, 255, 105, 180));  // צבע ורוד
                break;
            case "Yellow":
                l2.setBackgroundColor(Color.YELLOW);  // צבע צהוב
                break;
            default:
                l2.setBackgroundColor(Color.WHITE);  // ברירת מחדל: צבע לבן
        }
    }
}