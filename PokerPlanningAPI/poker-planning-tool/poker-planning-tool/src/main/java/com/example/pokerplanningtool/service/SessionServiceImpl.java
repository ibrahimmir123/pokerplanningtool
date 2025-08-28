package com.example.pokerplanningtool.service;

import com.example.pokerplanningtool.dto.SessionRequestDTO;
import com.example.pokerplanningtool.dto.SessionResponseDTO;
import com.example.pokerplanningtool.dto.UserStoryDTO;
import com.example.pokerplanningtool.exception.SessionNotFoundException;
import com.example.pokerplanningtool.model.Member;
import com.example.pokerplanningtool.model.Session;
import com.example.pokerplanningtool.model.UserStory;
import com.example.pokerplanningtool.repository.MemberRepository;
import com.example.pokerplanningtool.repository.SessionRepository;
import com.example.pokerplanningtool.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class SessionServiceImpl implements SessionService {

    @Value("${app.base-url:http://localhost:8080}")
    private String baseUrl;

    private final SessionRepository sessionRepository;
    private final MemberRepository memberRepository;
    private final UserStoryRepository userStoryRepository;

    public SessionServiceImpl(SessionRepository sessionRepository, MemberRepository memberRepository, UserStoryRepository userStoryRepository) {
        this.sessionRepository = sessionRepository;
        this.memberRepository = memberRepository;
        this.userStoryRepository = userStoryRepository;
    }

    @Override
    public SessionResponseDTO createSession(SessionRequestDTO request) {
        Session session = new Session();
        session.setTitle(request.getTitle());
        session.setDeckType(request.getDeckType());
        session.setActive(true);
        Session saved = sessionRepository.save(session);

        SessionResponseDTO response = new SessionResponseDTO();
        response.setSessionId(saved.getSessionId());
        response.setTitle(saved.getTitle());
        response.setDeckType(saved.getDeckType());
        response.setInviteLink(baseUrl + "/session/join/" + saved.getSessionId());

        return response;
    }

    @Override
    public SessionResponseDTO joinSession(UUID sessionId, String nickname) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new SessionNotFoundException("Session not found"));

        if (!session.isActive()) {
            throw new IllegalStateException("Session is inactive");
        }

        // Save member
        Member member = new Member();
        member.setNickname(nickname);
        member.setSession(session);
        memberRepository.save(member);

        // Fetch members
        List<String> memberNames = memberRepository.findBySession_SessionId(sessionId).stream()
                .map(Member::getNickname)
                .toList();

        // Fetch user stories
        List<UserStoryDTO> storyDTOs = userStoryRepository.findBySession_SessionId(sessionId).stream()
                .map(story -> new UserStoryDTO(story.getUserStoryId(), story.getTitle(), story.getDescription()))
                .toList();

        // Build response
        SessionResponseDTO response = new SessionResponseDTO();
        response.setSessionId(session.getSessionId());
        response.setTitle(session.getTitle());
        response.setDeckType(session.getDeckType());
        response.setInviteLink(baseUrl + "/session/join/" + session.getSessionId());
        response.setMembers(memberNames);
        response.setUserStories(storyDTOs);

        return response;
    }
    @Override
    public UserStoryDTO addUserStory(UUID sessionId, UserStoryDTO userStoryDTO) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new SessionNotFoundException("Session not found"));

        UserStory story = new UserStory();
        story.setTitle(userStoryDTO.getTitle());
        story.setDescription(userStoryDTO.getDescription());
        story.setSession(session);

        userStoryRepository.save(story);

        return new UserStoryDTO(story.getUserStoryId(), story.getTitle(), story.getDescription());
    }

    @Override
    public void destroySession(UUID sessionId) {
        Session session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new SessionNotFoundException("Session not found"));

        // Delete all members first
        List<Member> members = memberRepository.findBySession_SessionId(sessionId);
        memberRepository.deleteAll(members);

        // Delete all user story first
        List<UserStory> stories = userStoryRepository.findBySession_SessionId(sessionId);
        userStoryRepository.deleteAll(stories);

        sessionRepository.delete(session);
    }
}
