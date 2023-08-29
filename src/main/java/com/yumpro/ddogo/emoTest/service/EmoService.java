package com.yumpro.ddogo.emoTest.service;

import com.yumpro.ddogo.emoTest.entity.Emoreview;
import com.yumpro.ddogo.emoTest.repository.EmoRepository;
import com.yumpro.ddogo.emoTest.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmoService {

    private final EmoRepository emoRepository;

    public void updateReview(String reveiw,int hotplace_no,int map_no,double emo_result){
        Emoreview emoreview = new Emoreview();
        emoreview.setReview(reveiw);
        emoreview.setHotplace_no(hotplace_no);
        emoreview.setMap_no(map_no);
        emoreview.setEmo_result(emo_result);
        emoRepository.save(emoreview);
    }
}
