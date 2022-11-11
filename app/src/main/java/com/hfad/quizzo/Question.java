package com.hfad.quizzo;

import java.util.ArrayList;

public class Question {

    private String genre;
    private String question;
    private ArrayList<String> options = new ArrayList<String>();
    private String answer;
    private String fact;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public Question(String genre, String question, ArrayList<String> options, String answer, String fact) {
        this.genre = genre;
        this.question = question;
        this.options = options;
        this.answer = answer;
        this.fact = fact;
    }


}
