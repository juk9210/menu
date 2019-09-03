package com.juk.menu.service;

import com.juk.menu.model.Roll;
import com.juk.menu.repository.CompositionRepository;
import com.juk.menu.repository.RollRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RollService {
    private final RollRepository rollRepository;
    private final CompositionRepository compositionRepository;

    public RollService(RollRepository rollRepository, CompositionRepository compositionRepository) {
        this.rollRepository = rollRepository;
        this.compositionRepository = compositionRepository;
    }
public List<Roll> findByOrderByWeightAsc(){
        return rollRepository.findByOrderByWeightAsc();
}
    public List<Roll> findByOrderByWeightDesc(){
        return rollRepository.findByOrderByWeightDesc();
    }
    public List<Roll> findByOrderByPriceAsc(){
        return rollRepository.findByOrderByPriceAsc();
    }
    public List<Roll> findByOrderByPriceDesc(){
        return rollRepository.findByOrderByPriceDesc();
    }
    public List<Roll> findByTypeOfRoll(String typeOfRoll){
        return rollRepository.findByTypeOfRoll(typeOfRoll);
    }
}
