package com.example.pokerplanningtool.dto;

import java.util.List;
import java.util.UUID;

public class SessionResponseDTO {
    private UUID sessionId;
    private String inviteLink;
    private String title;
    private String deckType;
    private List<String> members;
    private List<UserStoryDTO> userStories;

    public UUID getSessionId() {
        return sessionId;
    }

    public void setSessionId(UUID sessionId) {
        this.sessionId = sessionId;
    }

    public String getInviteLink() {
        return inviteLink;
    }

    public void setInviteLink(String inviteLink) {
        this.inviteLink = inviteLink;
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

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public List<UserStoryDTO> getUserStories() {
        return userStories;
    }

    public void setUserStories(List<UserStoryDTO> userStories) {
        this.userStories = userStories;
    }
}
