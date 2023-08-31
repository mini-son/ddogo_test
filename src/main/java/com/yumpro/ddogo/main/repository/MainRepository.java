package com.yumpro.ddogo.main.repository;

import org.springframework.dao.DataAccessException;

import java.util.HashMap;
import java.util.List;

public interface MainRepository {

    public int mapno() throws DataAccessException;

    public List eatjjim(HashMap map);

    public List cafejjim(HashMap map);
}
