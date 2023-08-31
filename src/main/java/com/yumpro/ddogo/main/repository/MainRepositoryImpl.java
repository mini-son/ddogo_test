package com.yumpro.ddogo.main.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class MainRepositoryImpl implements MainRepository{
    @Autowired
    private SqlSession sqlSession;

    @Override
    public int mapno() throws DataAccessException {
        int mapno = (Integer)sqlSession.selectOne("main.mapno");
        return mapno;
    }

    @Override
    public List eatjjim(HashMap map){
        List eatjjimList = sqlSession.selectList("main.allBestEatJjim",map);
        return eatjjimList;
    }

    @Override
    public List cafejjim(HashMap map){
        List cafejjimList = sqlSession.selectList("main.allBestCafeJjim",map);
        return cafejjimList;
    }

}
