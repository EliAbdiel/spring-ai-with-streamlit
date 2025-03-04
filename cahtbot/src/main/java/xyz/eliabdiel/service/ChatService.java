package xyz.eliabdiel.service;

import org.springframework.http.ResponseEntity;
import xyz.eliabdiel.model.Question;

public interface ChatService {

    ResponseEntity<?> generateResponse(Question question);
}
