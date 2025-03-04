package com.example.triviab;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Collection2 {
        private Random random;
        private ArrayList<Question> arr; // רשימה לאחסון השאלות
        private int index; // משתנה למעקב אחרי המיקום הנוכחי בשאלות
    private Timer timer; // אובייקט של טיימר
    private TimerDisplay timerDisplay;
    private static final int QUESTION_TIME_LIMIT = 30 ; // הגבלת זמן לשאלה (30 שניות

        // קונסטרקטור שמאתחל את השאלות ומוסיף אותן לרשימה
        public Collection2() {
            arr = new ArrayList<>(); // יצירת אובייקט של ArrayList לאחסון השאלות
            timerDisplay = new TimerDisplay(); // יצירת אובייקט TimerDisplay להצגת הזמן

            // יצירת השאלות והוספתן לרשימה
            Question q1 = new Question("1+10", "7", "11", "3", "100", 2);
            Question q2 = new Question("1+2", "8", "2", "3", "100", 3);
            Question q3 = new Question("1+3", "6", "2", "4", "100", 3);
            Question q4 = new Question("1+4", "5", "2", "3", "100", 1);
            Question q5 = new Question("1+0", "1", "2", "3", "100", 1);

            // הוספת 3 שאלות נוספות
            Question q6 = new Question("2+5", "3", "7", "9", "10", 2);
            Question q7 = new Question("3+6", "8", "9", "7", "10", 2);
            Question q8 = new Question("4+5", "10", "8", "12", "9", 1);

            // הוספת השאלות לרשימה
            arr.add(q1);
            arr.add(q2);
            arr.add(q3);
            arr.add(q4);
            arr.add(q5);
            arr.add(q6); // הוספת השאלה השישית
            arr.add(q7); // הוספת השאלה השביעית
            arr.add(q8); // הוספת השאלה השמינית

            // ערבוב השאלות ברשימה באמצעות אלגוריתם Fisher-Yates
            shuffleQuestions(); // ערבוב השאלות בעזרת אלגוריתם Fisher-Yates
        }

    // אלגוריתם Fisher-Yates לערבוב השאלות
    private void shuffleQuestions() {
        Random rand = new Random();
        for (int i = arr.size() - 1; i > 0; i--) {
            // בוחר אקראית את אינדקס השאלה שברצוננו להחליף
            int j = rand.nextInt(i + 1);
            // מחליפים את השאלות במיקומים
            Question temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
        }
    }

    // אתחול של השאלה הראשונה
    public void initQuestions() {
        index = 0; // אתחול המשתנה index למקום הראשון
        startTimer(); // התחלת טיימר חדש לשאלה הראשונה
    }

    // הפעלת טיימר של 30 שניות לכל שאלה
    private void startTimer() {
        // ביטול הטיימר הקודם אם קיים
        if (timer != null) {
            timer.cancel();
        }

        // יצירת טיימר חדש
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int timeRemaining = QUESTION_TIME_LIMIT; // זמן שנשאר לשאלה

            @Override
            public void run() {
                if (timeRemaining > 0) {
                    // עדכון הזמן שנשאר
                    timeRemaining--;
                    timerDisplay.updateTimerDisplay(timeRemaining); // עדכון הזמן במסך
                } else {
                    // כאשר הזמן נגמר, עוברים לשאלה הבאה
                    moveToNextQuestion();
                    timer.cancel(); // ביטול הטיימר
                }
            }
        }, 0, 1000); // התחלת טיימר של 1 שניה
    }

    // פונקציה שמעבירה לשאלה הבאה ברשימה
    public void moveToNextQuestion() {
        // בדיקה אם יש שאלות נוספות
        if (isNotLastQuestion()) {
            getNextQuestion(); // שואל את השאלה הבאה
        }
    }

    // פונקציה שמחזירה את השאלה הבאה ברשימה
    public Question getNextQuestion() {
        // אם אנחנו לא בשאלה האחרונה, נחזיר את השאלה הנוכחית ואז נעדכן את המיקום
        if (index < arr.size()) {
            Question currentQuestion = arr.get(index++);
            startTimer(); // התחלת טיימר לשאלה החדשה
            return currentQuestion;
        }
        return null; // אם אין עוד שאלות, מחזירים null
    }

    // פונקציה שבודקת אם אנחנו לא בשאלה האחרונה
    public boolean isNotLastQuestion() {
        // הפונקציה מחזירה true אם אנחנו לא בשאלה האחרונה
        return index < arr.size(); // אם המיקום הנוכחי קטן מגודל הרשימה, אז אנחנו לא בשאלה האחרונה
    }

    // פונקציה שמחזירה את המיקום הנוכחי בשאלות
    public int getIndex() {
        return index + 1; // מחזירים את המיקום הנוכחי בשאלות, כאשר המיקום מתחיל מ-1 ולא מ-0
    }
}

// מחלקה להצגת הזמן שנשאר בשאלה
class TimerDisplay {
    public void updateTimerDisplay(int timeRemaining) {
        // מציג את הזמן שנשאר בשאלה
        System.out.println("זמן נשאר: " + timeRemaining + " שניות");
    }
}