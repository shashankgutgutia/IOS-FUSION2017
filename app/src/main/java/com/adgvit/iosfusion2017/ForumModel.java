package com.adgvit.iosfusion2017;


public class ForumModel {
    private String Name;
    private String Register;
    private String Verified;
    private String Question;

    public ForumModel() {
    }

    public ForumModel(String name, String register, String verified, String question) {
        this.Name = name;
        this.Register = register;
        this.Verified = verified;
        this.Question = question;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRegister() {
        return Register;
    }

    public void setRegister(String register) {
        Register = register;
    }

    public String getVerified() {
        return Verified;
    }

    public void setVerified(String verified) {
        Verified = verified;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }
}
