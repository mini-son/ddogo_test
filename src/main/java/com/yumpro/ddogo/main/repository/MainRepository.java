package com.yumpro.ddogo.main.repository;

import com.yumpro.ddogo.main.dto.SidogugunDTO;
import org.springframework.dao.DataAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MainRepository {

    public int mapno() throws DataAccessException;


    public List<HashMap<String, Object>> eatjjim();

    public List<HashMap<String, Object>> cafejjim();


    public List<String> getSelectList() throws DataAccessException;;

    public List<String> gugunList(String sido) throws DataAccessException;;
}
