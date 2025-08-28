package com.example.pokerplanningtool.service;

import com.example.pokerplanningtool.dto.SessionRequestDTO;
import com.example.pokerplanningtool.dto.SessionResponseDTO;
import com.example.pokerplanningtool.dto.UserStoryDTO;

import java.util.UUID;

public interface SessionService {
    public SessionResponseDTO createSession(SessionRequestDTO request);
    public SessionResponseDTO joinSession(UUID sessionId, String nickname);
    public UserStoryDTO addUserStory(UUID sessionId, UserStoryDTO userStoryDTO);
    public void destroySession(UUID sessionId);
}
