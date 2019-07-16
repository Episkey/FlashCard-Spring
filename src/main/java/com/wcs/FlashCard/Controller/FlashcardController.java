package com.wcs.FlashCard.Controller;

import com.wcs.FlashCard.Model.Flashcard;
import com.wcs.FlashCard.Model.User;
import com.wcs.FlashCard.Repository.FlashcardRepository;
import com.wcs.FlashCard.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlashcardController {

    @Autowired
    private FlashcardRepository flashcardRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/flashcards")
    public List<Flashcard> read() {
        return flashcardRepository.findAll();
    }

    @GetMapping("/flashcards/{flashcardId}")
    public Flashcard read(@PathVariable Long flashcardId) {
        return flashcardRepository.findById(flashcardId).get();
    }

    @PostMapping("/user/{userId}/flashcards")
    public Flashcard create(@PathVariable Long userId,
                            @RequestBody Flashcard picture) {
        User user = userRepository.findById(userId).get();
        picture.setUser(user);
        return flashcardRepository.save(picture);
    }

    @PutMapping("/flashcards/{flashcardId}")
    public Flashcard update(@PathVariable Long flashcardId,
                            @RequestBody Flashcard flashcard) {
        Flashcard flashcardToUpdate = flashcardRepository.findById(flashcardId).get();
        if (flashcard.getName() != null) {
            flashcardToUpdate.setName(flashcard.getName());
        }
        if (flashcard.getQuestion() != null) {
            flashcardToUpdate.setQuestion(flashcard.getQuestion());
        }
        if (flashcard.getAnswer() != null) {
            flashcardToUpdate.setAnswer(flashcard.getAnswer());
        }
        return flashcardRepository.save(flashcardToUpdate);
    }

}
