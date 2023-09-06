package com.yumpro.ddogo.main.repository;

import com.yumpro.ddogo.main.dto.SidogugunDTO;
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
    public List<HashMap<String, Object>> eatjjim(){
        List<HashMap<String, Object>> eatjjimList = sqlSession.selectList("main.allBestEatJjim");
        return eatjjimList;
    }

    @Override
    public List<HashMap<String, Object>> cafejjim(){
        List<HashMap<String, Object>> cafejjimList = sqlSession.selectList("main.allBestCafeJjim");
        return cafejjimList;
    }

    @Override
    public List<String> getSelectList() throws DataAccessException{
        return sqlSession.selectList("main.sidogugun");
    }

    @Override
    public List<String> gugunList(String sido) throws DataAccessException{
        List<String> gugunList = sqlSession.selectList("main.gugunList",sido);
        return gugunList;
    }

    @Override
    public List<HashMap<String, Object>> monthBest(Map<String, Object> paramMap) {
        return sqlSession.selectList("main.monthBest", paramMap);
    }

    @Override
    public String getAddress(int hotplace_no) {
        return sqlSession.selectOne("main.getAddress",hotplace_no);
    }


}
