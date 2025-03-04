package com.example.triviab;

import java.util.ArrayList;
import java.util.Random;


public class Collection2 {
        private Random random;
        private ArrayList<Question> arr; // רשימה לאחסון השאלות
        private int index; // משתנה למעקב אחרי המיקום הנוכחי בשאלות

        // קונסטרקטור שמאתחל את השאלות ומוסיף אותן לרשימה
        public Collection2() {
            arr = new ArrayList<>(); // יצירת אובייקט של ArrayList לאחסון השאלות

            // יצירת השאלות והוספתן לרשימה
            Question q1 = new Question("1+10", "7", "11", "3", "100", 2);
            Question q2 = new Question("1+2", "8", "2", "3", "100", 3);
            Question q3 = new Question("1+3", "6", "2", "4", "100", 3);
            Question q4 = new Question("1+4", "5", "2", "3", "100", 1);
            Question q5 = new Question("1+0", "1", "2", "3", "100", 1);

            // הוספת 3 שאלות נוספות
            Question q6 = new Question("2+5", "3", "7", "9", "10", 2);
            Question q7 = new Question("3+13", "8", "9", "12", "16", 4);
            Question q8 = new Question("4+5", "10", "8", "12", "9", 4);

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
        }

        // פונקציה שמחזירה את השאלה הבאה ברשימה
        public Question getNextQuestion() {
            // אם אנחנו לא בשאלה האחרונה, נחזיר את השאלה הנוכחית ואז נעדכן את המיקום
            if (index < arr.size()) {
                return arr.get(index++); // מחזירים את השאלה הנוכחית ומעבירים לשאלה הבאה
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
