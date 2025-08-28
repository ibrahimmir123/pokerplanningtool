package com.example.pokerplanningtool.model;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userStoryId;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    private int emittedVotes = 0;

    @ElementCollection
    private Map<UUID, Integer> voteSummary = new HashMap<>();

    public UserStory() {
    }

    public UserStory(UUID userStoryId, String description, Status status) {
        this.userStoryId=userStoryId;
        this.description=description;
        this.status=status;
    }

    public enum Status {
        PENDING, VOTING, VOTED
    }

    public UUID getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(UUID userStoryId) {
        this.userStoryId = userStoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getEmittedVotes() {
        return emittedVotes;
    }

    public void setEmittedVotes(int emittedVotes) {
        this.emittedVotes = emittedVotes;
    }

    public Map<UUID, Integer> getVoteSummary() {
        return voteSummary;
    }

    public void setVoteSummary(Map<UUID, Integer> voteSummary) {
        this.voteSummary = voteSummary;
    }
}
