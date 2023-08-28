package com.yumpro.ddogo.emoTest.service;

import com.yumpro.ddogo.emoTest.entity.Emoreview;
import com.yumpro.ddogo.emoTest.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public void add(String reveiw,int hotplace_no,int map_no,double emo_result){
        Emoreview emoreview = new Emoreview();
        emoreview.setReview(reveiw);
        emoreview.setHotplace_no(hotplace_no);
        emoreview.setMap_no(map_no);
        emoreview.setEmo_result(emo_result);
        reviewRepository.save(emoreview);
    }
}
