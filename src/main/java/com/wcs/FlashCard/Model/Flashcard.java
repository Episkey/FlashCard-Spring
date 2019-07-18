package com.wcs.FlashCard.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFlashcard;

    private String name;

    private String question;

    private String answer;

    private String general;

    private String code;

    private boolean learned;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonIgnore
    private User user;

    public Flashcard() {

    }

    public Long getIdFlashcard() {
        return idFlashcard;
    }

    public void setIdFlashcard(Long idFlashcard) {
        this.idFlashcard = idFlashcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isLearned() {
        return learned;
    }

    public void setLearned(boolean learned) {
        this.learned = learned;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
