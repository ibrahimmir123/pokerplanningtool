package com.example.pokerplanningtool.dto;

import java.util.UUID;

public class UserStoryDTO {
    private UUID userStoryId;
    private String title;
    private String description;

    public UserStoryDTO() {
    }

    public UserStoryDTO(UUID userStoryId, String title, String description) {
        this.userStoryId = userStoryId;
        this.title = title;
        this.description = description;
    }

    public UUID getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(UUID id) {
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
}
