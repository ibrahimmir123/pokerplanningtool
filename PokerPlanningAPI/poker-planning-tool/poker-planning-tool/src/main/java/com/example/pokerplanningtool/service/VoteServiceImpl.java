package com.example.pokerplanningtool.service;

import com.example.pokerplanningtool.dto.VoteRequestDTO;
import com.example.pokerplanningtool.dto.VoteStatusDTO;
import com.example.pokerplanningtool.model.UserStory;
import com.example.pokerplanningtool.model.Vote;
import com.example.pokerplanningtool.repository.VoteRepository;
import com.example.pokerplanningtool.repository.VoteUserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteRepository voteRepo;
    @Autowired private VoteUserStoryRepository storyRepo;

    @Override
    public void startVoting(UUID userStoryId) {
        UserStory story = storyRepo.findById(userStoryId).orElseThrow();
        if (story.getStatus() == UserStory.Status.PENDING || story.getStatus() == UserStory.Status.VOTED) {
            story.setStatus(UserStory.Status.VOTING);
            story.setEmittedVotes(0);
            storyRepo.save(story);
        }
    }

    @Override
    public void emitVote(VoteRequestDTO dto) {
        UserStory story = storyRepo.findById(dto.getUserStoryId()).orElseThrow();
        if (story.getStatus() != UserStory.Status.VOTING) throw new IllegalStateException("Voting not active");

        if (voteRepo.existsByUserStoryIdAndMemberId(dto.getUserStoryId(), dto.getMemberId())) return;

        Vote vote = new Vote();
        vote.setMemberId(dto.getMemberId());
        vote.setUserStoryId(dto.getUserStoryId());
        vote.setValue(dto.getVoteValue());
        vote.setRevealed(false);
        voteRepo.save(vote);

        story.setEmittedVotes(story.getEmittedVotes() + 1);
        storyRepo.save(story);
    }

    @Override
    public VoteStatusDTO getVotingStatus(UUID userStoryId) {
        List<Vote> votes = voteRepo.findByUserStoryId(userStoryId);
        List<UUID> voters = votes.stream().map(Vote::getMemberId).collect(Collectors.toList());

        UserStory story = storyRepo.findById(userStoryId).orElseThrow();
        return new VoteStatusDTO(userStoryId, story.getEmittedVotes(), voters);
    }

    @Override
    public void finishVoting(UUID userStoryId) {
        UserStory story = storyRepo.findById(userStoryId).orElseThrow();
        if (story.getStatus() != UserStory.Status.VOTING) return;

        List<Vote> votes = voteRepo.findByUserStoryId(userStoryId);
        Map<UUID, Integer> summary = new HashMap<>();
        for (Vote vote : votes) {
            vote.setRevealed(true);
            voteRepo.save(vote);
            summary.put(vote.getMemberId(), vote.getValue());
        }
        story.setStatus(UserStory.Status.VOTED);
        story.setVoteSummary(summary);
        storyRepo.save(story);
    }
}
