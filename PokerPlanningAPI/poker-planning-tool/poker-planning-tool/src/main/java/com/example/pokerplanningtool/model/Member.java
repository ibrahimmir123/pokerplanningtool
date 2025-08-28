package com.example.pokerplanningtool.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID memberId;
    private String nickname;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    public UUID getMemberId() {
        return memberId;
    }

    public void setMemberId(UUID memberid) {
        this.memberId = memberId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
