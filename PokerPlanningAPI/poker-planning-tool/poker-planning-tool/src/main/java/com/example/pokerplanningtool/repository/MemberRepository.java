package com.example.pokerplanningtool.repository;

import com.example.pokerplanningtool.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MemberRepository extends JpaRepository<Member, UUID> {
    List<Member> findBySession_SessionId(UUID sessionId);
}
