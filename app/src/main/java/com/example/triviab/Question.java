package com.example.triviab;

public class Question {
    // משתנים פרטיים עבור השאלה והתשובות
    private String question, a1, a2, a3, a4;
    private int correct;  // משתנה לציון התשובה הנכונה (מספר אינדקס של תשובה נכונה)

    // קונסטרקטור שמאתחל את כל המשתנים
    public Question(String question, String a1, String a2, String a3, String a4, int correct) {
        this.question = question;  // אתחול השאלה
        this.a1 = a1;  // אתחול תשובה 1
        this.a2 = a2;  // אתחול תשובה 2
        this.a3 = a3;  // אתחול תשובה 3
        this.a4 = a4;  // אתחול תשובה 4
        this.correct = correct;  // אתחול התשובה הנכונה (באינדקס)
    }

    // גטר (getter) לשאלה
    public String getQuestion() {
        return question;  // מחזיר את השאלה
    }

    // סטןר (setter) לשאלה
    public void setQuestion(String question) {
        this.question = question;  // קובע את השאלה
    }

    // גטר (getter) לתשובה 1
    public String getA1() {
        return a1;  // מחזיר את תשובה 1
    }

    // סטןר (setter) לתשובה 1
    public void setA1(String a1) {
        this.a1 = a1;  // קובע את תשובה 1
    }

    // גטר (getter) לתשובה 2
    public String getA2() {
        return a2;  // מחזיר את תשובה 2
    }

    // סטןר (setter) לתשובה 2
    public void setA2(String a2) {
        this.a2 = a2;  // קובע את תשובה 2
    }

    // גטר (getter) לתשובה 3
    public String getA3() {
        return a3;  // מחזיר את תשובה 3
    }

    // סטןר (setter) לתשובה 3
    public void setA3(String a3) {
        this.a3 = a3;  // קובע את תשובה 3
    }

    // גטר (getter) לתשובה 4
    public String getA4() {
        return a4;  // מחזיר את תשובה 4
    }

    // סטןר (setter) לתשובה 4
    public void setA4(String a4) {
        this.a4 = a4;  // קובע את תשובה 4
    }

    // גטר (getter) לתשובה נכונה (אינדקס התשובה הנכונה)
    public int getCorrect() {
        return correct;  // מחזיר את אינדקס התשובה הנכונה
    }

    // סטןר (setter) לתשובה נכונה
    public void setCorrect(int correct) {
        this.correct = correct;  // קובע את אינדקס התשובה הנכונה
    }
}


