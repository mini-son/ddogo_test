package com.yumpro.ddogo.main.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Map<String, Object>> eatjjim(HashMap map){
        List<Map<String, Object>> eatjjimList = sqlSession.selectList("main.allBestEatJjim2",map);
        return eatjjimList;
    }

    @Override
    public List<HashMap<String, Object>> cafejjim2(HashMap map){
        List<HashMap<String, Object>> cafejjimList = sqlSession.selectList("main.allBestCafeJjim",map);
        return cafejjimList;
    }

    @Override
    public List<HashMap<String, Object>> eatjjim2(HashMap map){
        List<HashMap<String, Object>> eatjjimList = sqlSession.selectList("main.allBestEatJjim2",map);
        return eatjjimList;
    }

    @Override
    public List<Map<String, Object>> cafejjim(HashMap map){
        List<Map<String, Object>> cafejjimList = sqlSession.selectList("main.allBestCafeJjim",map);
        return cafejjimList;
    }

    @Override
    public double avgEmoResult(int hotplace_no){
        double avgEmoResult = sqlSession.selectOne("main.emoAnalAvg",hotplace_no);
        return avgEmoResult;
    }

}
