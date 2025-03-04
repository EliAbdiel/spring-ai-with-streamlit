package xyz.eliabdiel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.eliabdiel.model.Question;
import xyz.eliabdiel.service.ChatService;

@RestController
@RequestMapping("/api/agents")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/bots")
    public ResponseEntity<?> generateResponse(String query) {
        return chatService.generateResponse(new Question(query));
    }
}
