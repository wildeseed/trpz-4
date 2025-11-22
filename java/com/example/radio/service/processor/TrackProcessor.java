package com.example.radio.service.processor;

import com.example.radio.model.TrackEntity;
import com.example.radio.repository.TrackRepository; // Переконайся, що цей файл є в repository
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrackProcessor {

    private final TrackRepository trackRepository;
    private final ProcessingContext context;
    private final StrategyResolver resolver;

    // Цей метод можна викликати з контролера або RabbitMQ Listener
    public void processTrack(String trackId) {
        TrackEntity track = trackRepository.findById(trackId).orElse(null);
        if (track == null) return;

        try {
            // Крок 1
            context.setStrategy(resolver.getStrategy(ProcessingType.VALIDATION));
            context.executeStrategy(track);

            // Крок 2
            context.setStrategy(resolver.getStrategy(ProcessingType.METADATA));
            context.executeStrategy(track);

            track.setStatus("READY");
            trackRepository.save(track);
            log.info("Track processing completed.");

        } catch (Exception e) {
            track.setStatus("ERROR");
            trackRepository.save(track);
        }
    }
}