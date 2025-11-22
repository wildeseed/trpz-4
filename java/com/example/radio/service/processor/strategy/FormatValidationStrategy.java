package com.example.radio.service.processor.strategy;

import com.example.radio.model.TrackEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("VALIDATION")
public class FormatValidationStrategy implements ProcessingStrategy {
    @Override
    public void execute(TrackEntity track) {
        log.info("Strategy: Validating format for track {}", track.getId());
        // Логіка перевірки...
        log.info("Format validation passed.");
    }
}