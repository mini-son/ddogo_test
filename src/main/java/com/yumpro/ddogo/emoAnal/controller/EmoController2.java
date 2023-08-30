package com.yumpro.ddogo.emoAnal.controller;

import com.yumpro.ddogo.emoAnal.entity.Emoreview;
import com.yumpro.ddogo.emoAnal.service.EmoService;
import com.yumpro.ddogo.emoAnal.validation.ReviewForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
@RequiredArgsConstructor
@RequestMapping("/emo")
@Controller
public class EmoController2 {

    private final EmoService emoService;

    @GetMapping("/reviewadd2")
    public String add(ReviewForm ReviewForm) {
        return "emoAnal/emoReviewForm";
    }

    @PostMapping("/reviewadd2")
    public String emoreview(@Valid ReviewForm reviewForm, BindingResult bindingResult, Emoreview emoreview) {

        double emo_result = emoService.emo(emoreview);


        if (bindingResult.hasErrors()) { //에러가 존재하면
            return "emoAnal/emoReviewForm";  //emoReviewForm.html문서로 이동
        }

        emoService.updateReview(reviewForm.getReview(), reviewForm.getHotplace_no(), reviewForm.getMap_no(), emo_result);
        return "emoAnal/imsi"; //리뷰등록 성공하면
    }

}
