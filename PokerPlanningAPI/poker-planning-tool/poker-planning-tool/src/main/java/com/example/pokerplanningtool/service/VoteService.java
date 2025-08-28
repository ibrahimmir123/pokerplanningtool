package com.example.pokerplanningtool.service;

import com.example.pokerplanningtool.dto.VoteRequestDTO;
import com.example.pokerplanningtool.dto.VoteStatusDTO;

import java.util.UUID;

public interface VoteService {
    void startVoting(UUID userStoryId);
    void emitVote(VoteRequestDTO dto);
    VoteStatusDTO getVotingStatus(UUID userStoryId);
    void finishVoting(UUID userStoryId);

}
