package com.yumpro.ddogo.main.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

public class MainRepositoryImpl implements MainRepository{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public void mapno() throws DataAccessException{

    }

}
