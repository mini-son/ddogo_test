package com.yumpro.ddogo.main.service;

import com.yumpro.ddogo.main.repository.OptionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class OptionService {

    private final OptionRepository optionRepository;

    public OptionService(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

  /*  public List<Option> findOption2() {
        return monthlyRentRepository.findByOption1();
    }*/
}