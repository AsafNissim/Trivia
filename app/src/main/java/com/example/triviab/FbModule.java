package com.example.triviab;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FbModule {

    private Context context;  // משתנה לאחסון ההפניה לפעילות (MainActivity)

    // בנאי של המודול, מקבל את הקונטקסט של MainActivity
    public FbModule(Context context) {
        this.context = context; // הפניה ל MainActivity

        FirebaseDatabase database = FirebaseDatabase.getInstance();  // יצירת אובייקט של FirebaseDatabase
        DatabaseReference reference = database.getReference("color");  // הפניה ל-"color" במסד הנתונים

        // מאזין לשינויים בערך של ה-"color" במסד הנתונים
        reference.addValueEventListener(
                new ValueEventListener() {
                    // פעולה שמתבצעת כאשר יש שינוי בנתונים
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String str = snapshot.getValue(String.class);  // שליפת הערך כ-string
                        if(str != null)  // אם יש ערך
                        {
                            // קריאה לפונקציה ב-MainActivity להעברת הצבע הנבחר
                            ((MainActivity)context).setNewColorFromFb(str);
                        }
                    }

                    // פעולה שמתבצעת אם יש שגיאה בקריאת הנתונים
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // במקרה של שגיאה, לא עושים כלום
                    }
                }
        );

    }

    // פונקציה ששולחת את הצבע החדש למסד הנתונים ב-Firebase
    public void writeBackgroundColorToFb(String color)
    {
        FirebaseDatabase database = FirebaseDatabase.getInstance();  // יצירת אובייקט של FirebaseDatabase
        DatabaseReference reference = database.getReference("color");  // הפניה ל-"color" במסד הנתונים
        reference.setValue(color);  // כתיבת הצבע החדש למסד הנתונים
    }
}

