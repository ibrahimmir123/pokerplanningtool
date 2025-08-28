package com.example.pokerplanningtool.controller;

import com.example.pokerplanningtool.dto.VoteRequestDTO;
import com.example.pokerplanningtool.dto.VoteStatusDTO;
import com.example.pokerplanningtool.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/votes")
public class VoteController {
    @Autowired
    private VoteService voteService;

    @PostMapping("/start/{userStoryId}")
    public ResponseEntity<String> startVoting(@PathVariable UUID userStoryId) {
        voteService.startVoting(userStoryId);
        return ResponseEntity.ok("Voting session started for user story: " + userStoryId);
}

    @PostMapping("/emit")
    public ResponseEntity<String> emitVote(@RequestBody VoteRequestDTO dto) {
        voteService.emitVote(dto);
        return ResponseEntity.ok("Vote successfully recorded for member: " + dto.getMemberId());
    }

    @GetMapping(value = "/status/{userStoryId}", produces = "application/json")
    public ResponseEntity<VoteStatusDTO> getStatus(@PathVariable UUID userStoryId) {
        return ResponseEntity.ok(voteService.getVotingStatus(userStoryId));
    }

    @PostMapping("/finish/{userStoryId}")
    public ResponseEntity<String> finishVoting(@PathVariable UUID userStoryId) {
        voteService.finishVoting(userStoryId);
        return ResponseEntity.ok("Voting session finished for user story: " + userStoryId);
    }

}
