package com.example.radio.service.processor.strategy;

import com.example.radio.model.TrackEntity;

public interface ProcessingStrategy {
    void execute(TrackEntity track);
}