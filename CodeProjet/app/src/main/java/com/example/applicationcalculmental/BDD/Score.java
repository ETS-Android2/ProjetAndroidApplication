package com.example.applicationcalculmental.BDD;

import com.example.applicationcalculmental.R;

import java.sql.Date;

public class Score {
    private int id;
    private String name, difficulty;
    private double score;
    private Date date;

    public Score(String name, double score, int difficulty) {
        this.id = 0;
        this.name = name;
        this.score = score;

        switch (difficulty) {
            case 1:
                this.difficulty = "easy";
                break;
            case 2:
                this.difficulty= "medium";
                break;
            case 3:
                this.difficulty = "hard";
                break;
            default:
                this.difficulty = "undifined";
        }

        this.date = new Date(new java.util.Date().getTime());
    }

    public Score(int id, String name, String difficulty, double score, Date date) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.score = score;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
