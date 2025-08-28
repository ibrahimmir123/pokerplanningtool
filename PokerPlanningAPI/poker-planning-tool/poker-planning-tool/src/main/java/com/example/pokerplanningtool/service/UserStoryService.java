package com.example.pokerplanningtool.service;

import com.example.pokerplanningtool.dto.UserStoryRequestDTO;
import com.example.pokerplanningtool.dto.UserStoryResponseDTO;

import java.util.List;
import java.util.UUID;

public interface UserStoryService {
    UserStoryResponseDTO addUserStory(UserStoryRequestDTO dto);
    String deleteUserStory(UUID id);
    List<UserStoryResponseDTO> getAllUserStories();
}

