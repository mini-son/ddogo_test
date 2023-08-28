package com.yumpro.ddogo.emoTest.controller;

import com.yumpro.ddogo.emoTest.entity.Emoreview;
import com.yumpro.ddogo.emoTest.service.ReviewService;
import com.yumpro.ddogo.emoTest.validation.ReviewForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.validation.Valid;

@RequestMapping("/review")
@RequiredArgsConstructor
@Controller
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/add")
    public String add(ReviewForm ReviewForm) {
        return "emo/emoReviewForm";
    }

    @PostMapping("/add")
    public String reviewadd(@Valid ReviewForm reviewForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { //에러가 존재하면
            return "emo/emoReviewForm";  //emoreview.html문서로 이동
        }
        reviewService.add(reviewForm.getReview(), reviewForm.getHotplace_no(), reviewForm.getMap_no());
        return "emo/emoReviewForm";
    }
}
