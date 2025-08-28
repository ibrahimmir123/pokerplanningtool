package com.example.pokerplanningtool.dto;

import java.util.UUID;

public class UserStoryRequestDTO {
    private UUID userStoryId;
    private String description;

    public UserStoryRequestDTO() {
    }

    public UserStoryRequestDTO(UUID userStoryId, String description) {
        this.userStoryId = userStoryId;
        this.description = description;
    }

    public UUID getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(UUID userStoryId) {
        this.userStoryId = userStoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

