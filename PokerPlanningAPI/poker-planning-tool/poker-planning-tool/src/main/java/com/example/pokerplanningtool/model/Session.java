package com.example.pokerplanningtool.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID sessionId;

    private String title;
    private String deckType;
    private boolean active;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Member> members;

    public Session() {
    }

    public Session(UUID sessionId, String title, String deckType, boolean active) {
        this.sessionId = sessionId;
        this.title = title;
        this.deckType = deckType;
        this.active = active;
    }

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
