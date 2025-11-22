package com.example.radio.service.processor;

import com.example.radio.service.processor.strategy.ProcessingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StrategyResolver {
    private final Map<String, ProcessingStrategy> strategies;

    public ProcessingStrategy getStrategy(ProcessingType type) {
        return strategies.get(type.name());
    }
}