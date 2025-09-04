package com.abdelaziz26.ws;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/sendToAll")
    @SendTo("/topic/notifications")
    public String sendMessage(String message) {
        System.out.println(message);
        return message;
    }


    @PostMapping("notify-user")
    public void sendNotificationToUser(@PathVariable String userId, @RequestBody Map<String, String> body)
    {
        messagingTemplate.convertAndSendToUser(userId, "/queue/notifications", body.get("content"));
    }
}
