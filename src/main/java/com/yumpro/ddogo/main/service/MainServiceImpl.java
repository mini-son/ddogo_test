package com.yumpro.ddogo.main.service;

import com.yumpro.ddogo.main.dto.EmoreviewDTO;
import com.yumpro.ddogo.main.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MainServiceImpl implements MainService{
    @Autowired
    private MainRepository mainRepository;

    @Override
    public int mapno() throws Exception{
        int mapno = mainRepository.mapno();
        return mapno;
    }

/*    @Override
    public List<Map<String, Object>> eatjjim(HashMap map) throws Exception{
        List<Map<String, Object>> eatjjimList = mainRepository.eatjjim(map);
        return eatjjimList;
    }

    public List<Map<String, Object>> cafejjim(HashMap map) throws Exception{
        List<Map<String, Object>> cafejimList = mainRepository.cafejjim(map);
        return cafejimList;
    }
*/
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
