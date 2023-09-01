package com.yumpro.ddogo.main.service;

import com.yumpro.ddogo.main.dto.EmoreviewDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MainService {

    public int mapno() throws Exception;
/*
    public List<Map<String, Object>> eatjjim(HashMap map) throws Exception;

    public List<Map<String, Object>> cafejjim(HashMap map) throws Exception;
*/
    public List<HashMap<String, Object>> eatjjim() throws Exception;

    public List<HashMap<String, Object>> cafejjim() throws Exception;


}
