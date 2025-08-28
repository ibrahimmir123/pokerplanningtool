package com.example.pokerplanningtool.repository;

import com.example.pokerplanningtool.model.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserStoryRepository extends JpaRepository<UserStory, UUID> {
    List<UserStory> findBySession_SessionId(UUID sessionId);

}

