package com.yumpro.ddogo.main.repository;

import org.springframework.dao.DataAccessException;

public interface MainRepository {

    public int mapno() throws DataAccessException;
}
