package com.example.pokerplanningtool.dto;

public class SessionRequestDTO {
        private String title;
        private String deckType;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeckType() {
        return deckType;
    }

    public void setDeckType(String deckType) {
        this.deckType = deckType;
    }
}
