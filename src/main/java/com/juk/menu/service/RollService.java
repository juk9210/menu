package com.juk.menu.service;

import com.juk.menu.repository.CompositionRepository;
import com.juk.menu.repository.RollRepository;
import org.springframework.stereotype.Service;

@Service
public class RollService {
    private final RollRepository rollRepository;
    private final CompositionRepository compositionRepository;

    public RollService(RollRepository rollRepository, CompositionRepository compositionRepository) {
        this.rollRepository = rollRepository;
        this.compositionRepository = compositionRepository;
    }

}
