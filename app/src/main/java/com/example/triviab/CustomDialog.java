package com.example.triviab;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog implements View.OnClickListener {
    Button btnYes, btnNo;  // כפתורים לדיאלוג (אישור ודחייה)
    Context context;  // משתנה לאחסון הקונטקסט של הפעילות

    // בנאי לדיאלוג מותאם אישית
    public CustomDialog(@NonNull Context context) {
        super(context);

        setContentView(R.layout.custom_dialog);  // הצגת ה-layout של הדיאלוג
        this.context = context;  // שמירת ההפניה לפעילות

        // אתחול הכפתורים
        this.btnYes = findViewById(R.id.btnYes);
        this.btnNo = findViewById(R.id.btnNo);

        // קביעת מאזינים לכפתורים
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

        // לא מאפשר לסגור את הדיאלוג באמצעות חיצים או שיטות אחרות
        setCancelable(false);
    }

    // פונקציה שמתבצעת כאשר לוחצים על כפתור בדיאלוג
    @Override
    public void onClick(View view) {
        if (btnYes == view) {  // אם נלחץ כפתור "כן"
            dismiss();  // סגירת הדיאלוג
            // איפוס המשחק
            ((GameActivity) context).reset();
        }

        if (btnNo == view) {  // אם נלחץ כפתור "לא"
            // סיום הפעילות (סיום המשחק)
            ((GameActivity) context).finish();
        }
    }
}

