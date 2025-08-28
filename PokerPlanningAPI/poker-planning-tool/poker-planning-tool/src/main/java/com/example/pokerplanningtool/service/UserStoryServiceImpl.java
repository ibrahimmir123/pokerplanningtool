package com.example.pokerplanningtool.service;

import com.example.pokerplanningtool.dto.UserStoryRequestDTO;
import com.example.pokerplanningtool.dto.UserStoryResponseDTO;
import com.example.pokerplanningtool.repository.UserStoryRepository;
import com.example.pokerplanningtool.model.UserStory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserStoryServiceImpl implements UserStoryService{
    @Autowired
    private UserStoryRepository repository;

    @Override
    public UserStoryResponseDTO addUserStory(UserStoryRequestDTO dto) {
        UserStory story = new UserStory(dto.getUserStoryId(), dto.getDescription(), UserStory.Status.PENDING);
        repository.save(story);
        return new UserStoryResponseDTO(story.getUserStoryId(), story.getDescription(), story.getStatus().name());
    }

    @Override
    public String deleteUserStory(UUID userStoryId) {
        UserStory story = repository.findById(userStoryId).orElseThrow();
        if (story.getStatus() == UserStory.Status.PENDING) {
            repository.deleteById(userStoryId);
            return "User story successfully deleted.";
        } else {
            throw new IllegalStateException("Only PENDING stories can be deleted");
        }
    }

    @Override
    public List<UserStoryResponseDTO> getAllUserStories() {
        return repository.findAll().stream()
                .map(s -> new UserStoryResponseDTO(s.getUserStoryId(), s.getDescription(), s.getStatus().name()))
                .collect(Collectors.toList());
    }

}
