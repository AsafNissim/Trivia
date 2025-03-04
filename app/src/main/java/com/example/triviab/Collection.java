package com.example.triviab;

import java.util.ArrayList;

public class Collection {
    private ArrayList<Question> arr;  // רשימה לאחסון השאלות
    private int index;  // משתנה למעקב אחרי השאלה הנוכחית

    // בנאי - אתחול הרשימה והוספת שאלות
    public Collection()
    {
        arr = new ArrayList<>();  // יצירת אובייקט של ArrayList לאחסון השאלות

        // יצירת השאלות והוספתן לרשימה
        Question q1 = new Question("1+10","7", "11", "3","100", 2);
        Question q2 = new Question("1+2", "8", "2", "3","100", 3);
        Question q3 = new Question("1+3", "6", "2", "4","100", 3);
        Question q4 = new Question("1+4", "5", "2", "3","100", 1);
        Question q5 = new Question("1+0", "1", "2", "3","100", 1);

        arr.add (q1);  // הוספת השאלה הראשונה לרשימה
        arr.add (q2);  // הוספת השאלה השנייה לרשימה
        arr.add (q3);  // הוספת השאלה השלישית לרשימה
        arr.add (q4);  // הוספת השאלה הרביעית לרשימה
        arr.add (q5);  // הוספת השאלה החמישית לרשימה
    }

    // אתחול של מספר השאלה הנוכחית (מתחילים מהשאלה הראשונה)
    public void initQuestions()
    {
        index = 0;  // אתחול המשתנה index למקום הראשון
    }

    // פונקציה שמחזירה את השאלה הבאה ברשימה
    public Question getNextQuestion()
    {
        // הפונקציה מחזירה הפניה לשאלה הבאה ברשימה
        Question q = arr.get(index);
        index++;  // עדכון המיקום לשאלה הבאה
        return q;  // החזרת השאלה הנוכחית
    }

    // פונקציה שבודקת אם אנחנו בשאלה האחרונה
    public boolean isNotLastQuestion() {
        // הפונקציה מחזירה true אם אנחנו לא בשאלה האחרונה
        return (index < arr.size());  // אם אנחנו עדיין לא בסוף הרשימה
    }

    // פונקציה שמחזירה את המיקום הנוכחי (מספר השאלה הנוכחית)
    public int getIndex() {
        return index;
    }
}
