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
    public List<HashMap<String, Object>> eatjjim(){
        List<HashMap<String, Object>> eatjjimList = sqlSession.selectList("main.allBestEatJjim");
        return eatjjimList;
    }

    @Override
    public List<HashMap<String, Object>> cafejjim(){
        List<HashMap<String, Object>> cafejjimList = sqlSession.selectList("main.allBestCafeJjim");
        return cafejjimList;
    }


}
