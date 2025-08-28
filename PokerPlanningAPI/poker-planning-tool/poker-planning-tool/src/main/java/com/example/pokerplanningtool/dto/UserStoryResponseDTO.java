package com.example.pokerplanningtool.dto;

import java.util.UUID;

public class UserStoryResponseDTO {
    private UUID userStoryId;
    private String description;
    private String status;

    public UserStoryResponseDTO(UUID userStoryId, String description, String status) {
        this.userStoryId = userStoryId;
        this.description = description;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
