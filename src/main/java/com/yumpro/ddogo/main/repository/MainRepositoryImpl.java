package com.yumpro.ddogo.main.repository;

import com.yumpro.ddogo.main.dto.EmoreviewDTO;
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
    public List<Map<String, Object>> cafejjim(HashMap map){
        List<Map<String, Object>> eatjjimList = sqlSession.selectList("main.allBestEatJjim2",map);
        return eatjjimList;
    }

    @Override
    public List<HashMap<String, Object>> eatjjim2(){
        List<HashMap<String, Object>> eatjjimList = sqlSession.selectList("main.allBestEatJjim4");
        return eatjjimList;
    }

    @Override
    public List<HashMap<String, Object>> cafejjim2(){
        List<HashMap<String, Object>> cafejjimList = sqlSession.selectList("main.allBestCafeJjim");
        return cafejjimList;
    }


}
