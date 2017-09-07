package com.adgvit.iosfusion2017;


public class ForumModel {
    String name ;
    String  regno;
    String verfified;
    String question;

    public ForumModel(String name, String regno, String verfified, String question) {
        this.name = name;
        this.regno = regno;
        this.verfified = verfified;
        this.question = question;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getVerfified() {
        return verfified;
    }

    public void setVerfified(String verfified) {
        this.verfified = verfified;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
