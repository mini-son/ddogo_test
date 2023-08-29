package com.yumpro.ddogo.main.service;

import com.yumpro.ddogo.main.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService{
    @Autowired
    private MainRepository mainRepository;

    @Override
    public int mapno() throws Exception{
        return
    }
}
