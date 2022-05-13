package com.example.musicquiz;

public class Question {
    int id;
    String question;
    int image;
    String optionOne;
    String optionTwo;
    String optionThree;
    String optionFour;
    int correct;

    public Question(int id, String question, int image, String optionOne, String optionTwo, String optionThree, String optionFour, int correct) {
        this.id = id;
        this.question = question;
        this.image = image;
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.optionThree = optionThree;
        this.optionFour = optionFour;
        this.correct = correct;
    }
}
