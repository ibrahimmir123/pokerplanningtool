package com.example.pokerplanningtool.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pokerplanningtool.dto.UserStoryRequestDTO;
import com.example.pokerplanningtool.dto.UserStoryResponseDTO;
import com.example.pokerplanningtool.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/userstories")
public class UserStoryController {

    @Autowired
    private UserStoryService service;

    @PostMapping("/add")
    public ResponseEntity<UserStoryResponseDTO> addUserStory(@RequestBody UserStoryRequestDTO dto) {
        return ResponseEntity.ok(service.addUserStory(dto));
    }

    @DeleteMapping("/delete/{userStoryId}")
    public ResponseEntity<String> deleteUserStory(@PathVariable UUID userStoryId) {
        String message = service.deleteUserStory(userStoryId);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserStoryResponseDTO>> getAllStories() {
        return ResponseEntity.ok(service.getAllUserStories());
    }
}
