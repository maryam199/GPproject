package com.example.loginscreen;

public class Client{

    String age, loseORgain, height, weight, number;


    public Client(String age, String weight, String height){

    }

    public Client(String age, String weight, String height, String loseORgain, String number){
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.loseORgain = loseORgain;
        this.number = number;
    }


    public void setAge(String age) {
        this.age = age;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setLoseORgain(String loseORgain) {
        this.loseORgain = loseORgain;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getAge() {
        return age;
    }

    public String getLoseORgain() {
        return loseORgain;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getNumber() {
        return number;
    }
}
