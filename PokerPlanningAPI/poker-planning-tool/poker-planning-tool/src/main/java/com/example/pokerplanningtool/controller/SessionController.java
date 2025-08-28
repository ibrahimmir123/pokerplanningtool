package com.example.pokerplanningtool.controller;

import com.example.pokerplanningtool.dto.SessionRequestDTO;
import com.example.pokerplanningtool.dto.SessionResponseDTO;
import com.example.pokerplanningtool.dto.UserStoryDTO;
import com.example.pokerplanningtool.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/session")
public class SessionController {

    private SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/create")
    public SessionResponseDTO createSession(@RequestBody SessionRequestDTO request) {
        return sessionService.createSession(request);
    }

    @PostMapping("/join/{sessionId}")
    public SessionResponseDTO joinSession(@PathVariable UUID sessionId, @RequestParam String nickname) {
        return sessionService.joinSession(sessionId, nickname);
    }

    @PostMapping("/{sessionId}/user-story")
    public ResponseEntity<UserStoryDTO> addUserStory(
            @PathVariable UUID sessionId,
            @RequestBody UserStoryDTO userStoryDTO) {
        UserStoryDTO createdStory = sessionService.addUserStory(sessionId, userStoryDTO);
        return ResponseEntity.ok(createdStory);
    }

    @DeleteMapping("/destroy/{sessionId}")
    public String destroySession(@PathVariable UUID sessionId) {
        sessionService.destroySession(sessionId);
        return "Session destroyed successfully.";
    }
}
