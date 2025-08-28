package com.example.pokerplanningtool.dto;

import java.util.List;
import java.util.UUID;

public class VoteStatusDTO {
    private UUID userStoryId;
    private int emittedVotes;
    private List<UUID> voters;

    public VoteStatusDTO(UUID userStoryId, int emittedVotes, List<UUID> voters) {
        this.userStoryId = userStoryId;
        this.emittedVotes = emittedVotes;
        this.voters = voters;
    }


    public UUID getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(UUID userStoryId) {
        this.userStoryId = userStoryId;
    }

    public int getEmittedVotes() {
        return emittedVotes;
    }

    public void setEmittedVotes(int emittedVotes) {
        this.emittedVotes = emittedVotes;
    }

    public List<UUID> getVoters() {
        return voters;
    }

    public void setVoters(List<UUID> voters) {
        this.voters = voters;
    }
}

