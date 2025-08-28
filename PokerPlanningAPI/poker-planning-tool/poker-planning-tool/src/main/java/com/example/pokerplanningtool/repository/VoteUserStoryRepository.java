package com.example.pokerplanningtool.repository;

import com.example.pokerplanningtool.model.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VoteUserStoryRepository extends JpaRepository<UserStory, UUID> {}

