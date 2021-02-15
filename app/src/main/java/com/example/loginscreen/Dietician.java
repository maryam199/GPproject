package com.example.loginscreen;

public class Dietician {
    private String imageUri;

    public Dietician(){

    }

    public Dietician(String imageUri){
        this.imageUri = imageUri;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
