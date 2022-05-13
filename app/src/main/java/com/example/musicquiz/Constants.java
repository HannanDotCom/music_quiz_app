package com.example.musicquiz;

import java.util.ArrayList;
public final class Constants {
    public String USER_NAME = "username";
    public String TOTAL_QUESTIONS = "totalquestions";
    public String CORRECT_ANSWERS = "correct_answers";

    public ArrayList<Question> getQuestions() {
        ArrayList<Question> questionsList = new ArrayList<Question>();

        Question q1 = new Question(1, "Which artist recorded this album?",
                R.drawable.darkside,
                "The Rolling Stones",
                "The Beatles",
                "Pink Floyd",
                "Cream",
                3);

        Question q2 = new Question(2, "Which artist recorded this album?", R.drawable.ridofme, "Gwen Stefani", "PJ Harvey", "Fiona Apple", "Lana Del Rey", 2);

        Question q3 = new Question(3, "Which artist recorded this album?", R.drawable.damn, "Kendrick Lamar", "Eminem", "Playboi Carti", "Lil Uzi Vert", 1);

        Question q4 = new Question(4, "Which artist recorded this album?", R.drawable.folklore, "Ariana Grande", "Phoebe Bridgers", "Lucy Dacus", "Taylor Swift", 4);

        Question q5 = new Question(5, "Which artist recorded this album?", R.drawable.fineline, "Harry Styles", "Ed Sheeran", "Sam Smith", "Machine Gun Kelly", 1);


        questionsList.add(q1);
        questionsList.add(q2);
        questionsList.add(q3);
        questionsList.add(q4);
        questionsList.add(q5);

        return questionsList;
    }
}
