package com.example.radio.service.processor;

import com.example.radio.model.TrackEntity;
import com.example.radio.service.processor.strategy.ProcessingStrategy;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Setter
@Service
public class ProcessingContext {
    private ProcessingStrategy strategy;

    public void executeStrategy(TrackEntity track) {
        if (strategy != null) {
            strategy.execute(track);
        }
    }
}