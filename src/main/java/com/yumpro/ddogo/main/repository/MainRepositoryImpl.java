package com.yumpro.ddogo.main.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class MainRepositoryImpl implements MainRepository{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public int mapno() throws DataAccessException {
        int mapno = (Integer)sqlSession.selectOne("main.mapno");
        return mapno;
    }

}
