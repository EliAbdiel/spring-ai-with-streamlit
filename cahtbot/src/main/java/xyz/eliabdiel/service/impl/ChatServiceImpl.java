package xyz.eliabdiel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import xyz.eliabdiel.model.Answer;
import xyz.eliabdiel.model.Question;
import xyz.eliabdiel.service.ChatService;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatClient chatClient;

    @Override
    public ResponseEntity<?> generateResponse(Question question) {
        try {
            Answer answer = new Answer(getMessage(question).getResult().getOutput().getText());
            return ResponseEntity.ok(answer);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("error: " + e.getMessage());
        }
    }

    private ChatResponse getMessage(Question question) {
        try {
            return chatClient.prompt()
                    .user(question.getQuery())
                    .call()
                    .chatResponse();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
