package com.example.pokerplanningtool.repository;

import com.example.pokerplanningtool.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findByUserStoryId(UUID userStoryId);
    boolean existsByUserStoryIdAndMemberId(UUID userStoryId, UUID memberId);
}
