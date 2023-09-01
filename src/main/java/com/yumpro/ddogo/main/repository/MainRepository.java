package com.yumpro.ddogo.main.repository;

import com.yumpro.ddogo.main.dto.EmoreviewDTO;
import org.springframework.dao.DataAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MainRepository {

    public int mapno() throws DataAccessException;

  /*  public List<Map<String, Object>> eatjjim(HashMap map);

    public List<Map<String, Object>> cafejjim(HashMap map);
*/
    public List<HashMap<String, Object>> eatjjim();

    public List<HashMap<String, Object>> cafejjim();

}
