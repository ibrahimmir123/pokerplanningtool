package com.example.pokerplanningtool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Vote {
    @Id
    @GeneratedValue
    private Long voteId;
    private UUID memberId;
    private UUID userStoryId;
    private Integer voteValue;
    private boolean revealed;

    public Vote() {
    }

    public Vote(Long voteId, UUID memberId, UUID userStoryId, Integer voteValue, boolean revealed) {
        this.voteId = voteId;
        this.memberId = memberId;
        this.userStoryId = userStoryId;
        this.voteValue = voteValue;
        this.revealed = revealed;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public UUID getMemberId() {
        return memberId;
    }

    public void setMemberId(UUID memberId) {
        this.memberId = memberId;
    }

    public UUID getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(UUID userStoryId) {
        this.userStoryId = userStoryId;
    }

    public Integer getValue() {
        return voteValue;
    }

    public void setValue(Integer voteValue) {
        this.voteValue = voteValue;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }
}
