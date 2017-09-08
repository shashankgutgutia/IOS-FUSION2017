package com.adgvit.iosfusion2017;


public class ForumModel {
    String name ;
    String  regno;
    String verfified;
    String question;
    int count;

    public ForumModel(String name, String regno, String verfified, String question, int count) {
        this.name = name;
        this.regno = regno;
        this.verfified = verfified;
        this.question = question;
        this.count = count;
    }

    public int getCount() { return count; }

    public void setCount(int count) { this.count = count; }

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
