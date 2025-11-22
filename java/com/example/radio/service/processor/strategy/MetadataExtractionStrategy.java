package com.example.radio.service.processor.strategy;

import com.example.radio.model.TrackEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("METADATA")
public class MetadataExtractionStrategy implements ProcessingStrategy {
    @Override
    public void execute(TrackEntity track) {
        log.info("Strategy: Extracting metadata for track {}", track.getId());
        track.setDuration(345); // Приклад
        log.info("Metadata extracted.");
    }
}