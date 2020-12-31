package com.dekelbz.animals.listener;

import com.dekelbz.animals.entity.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepositoryListener {

    private final SimpMessagingTemplate messagingTemplate;

    @KafkaListener(topics = "animal-retrieved-by-id")
    public void animalRetrieved(Animal animal) {
        messagingTemplate.convertAndSend("/topic/greetings", animal);
    }
}
