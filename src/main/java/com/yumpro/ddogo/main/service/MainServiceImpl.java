package com.yumpro.ddogo.main.service;

import com.yumpro.ddogo.main.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MainServiceImpl implements MainService{
    @Autowired
    private MainRepository mainRepository;

    @Override
    public int mapno() throws Exception{
        int mapno = mainRepository.mapno();
        return mapno;
    }

    @Override
    public List<HashMap<String, Object>> eatjjim() throws Exception{
        List<HashMap<String, Object>> eatjjimList = mainRepository.eatjjim();
        return eatjjimList;
    }

    public List<HashMap<String, Object>> cafejjim() throws Exception{
        List<HashMap<String, Object>> cafejimList = mainRepository.cafejjim();
        return cafejimList;
    }



}
