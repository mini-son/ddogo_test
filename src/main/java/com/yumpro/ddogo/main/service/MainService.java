package com.yumpro.ddogo.main.service;

import com.yumpro.ddogo.main.dto.BestJjimDTO2;
import com.yumpro.ddogo.main.dto.SidogugunDTO;
import com.yumpro.ddogo.main.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MainService{
    @Autowired
    private MainRepository mainRepository;

    public int mapno() throws Exception{
        int mapno = mainRepository.mapno();
        return mapno;
    }

    public List<HashMap<String, Object>> eatjjim() throws Exception{
      /*  BestJjimDTO2 bestJjimDTO2 = new BestJjimDTO2();
        bestJjimDTO2.setHotplace_no();
        List<HashMap<String, Object>> ReviewList = mainService.getReview(hotplace_no);*/

        List<HashMap<String, Object>> eatjjimList = mainRepository.eatjjim();
        for(int i=0; i<eatjjimList.size(); i++){
            HashMap<String, Object> hm= eatjjimList.get(i);

            Set<String> set = hm.keySet();
            Iterator iter = set.iterator();	// Iterator 사용
            while(iter.hasNext()) {//값이 있으면 true 없으면 false
                String key =(String)iter.next();
                Object value =hm.get(key);
                System.out.println(key+"의 값은 "+value);
            }

           int hotplace_no = (Integer) hm.get("hotplace_no");
           // BestJjimDTO2 bestJjimDTO2 = new BestJjimDTO2();
           // bestJjimDTO2.setHotplace_no(hotplace_no);
           // bestJjimDTO2.setHotplace_name((String)hm.get("hotplace_name"));
           // bestJjimDTO2.setReviewList(hm.);
        }

        return eatjjimList;
    }

    public List<HashMap<String, Object>> cafejjim() throws Exception{
        List<HashMap<String, Object>> cafejimList = mainRepository.cafejjim();
        return cafejimList;
    }

    public Map<String, List<String>> getsidogungu() {
        Map<String, List<String>> sigunguMap = new HashMap<>();
        List<String> sidoList = mainRepository.getSelectList();

        for (String sido : sidoList) {
            List<String> sigunguList = mainRepository.gugunList(sido);
            sigunguMap.put(sido, sigunguList);
        }

        return sigunguMap;
    }

    public List<HashMap<String, Object>> monthBest(String sido, String gugugn,int hotplace_cate_no) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sido", sido);
        paramMap.put("gugun", gugugn);
        paramMap.put("hotplace_cate_no", hotplace_cate_no);

        return mainRepository.monthBest(paramMap);
    }


    public List<HashMap<String, Object>> getReview(int map_no) {
        return mainRepository.getReview(map_no);
    }

    /*public String getAddress(int hotplace_no){
        return mainRepository.getAddress(hotplace_no);
    }*/


}
