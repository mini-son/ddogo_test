package com.yumpro.ddogo.main.controller;

import com.yumpro.ddogo.main.dto.EmoreviewDTO;
import com.yumpro.ddogo.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@Controller
public class MainController {
    @Autowired
    private MainService mainService;

    @RequestMapping("test")
    public String mapno() throws Exception {

        int mapno = mainService.mapno();

        System.out.println("mapno="+mapno);
        return "main/test";
    }

    @RequestMapping("allBestEatJjim")
    public String allBestJjim(Model model, @RequestParam HashMap map) throws Exception {
        List<Map<String, Object>> eatjjim = mainService.eatjjim(map);
        List<Map<String, Object>> cafejjim = mainService.cafejjim(map);
        System.out.println("eatjjim="+eatjjim);
        System.out.println("cafejjim"+cafejjim);

        model.addAttribute("eatjjim",eatjjim);
        model.addAttribute("cafejjim",cafejjim);
        return "main/test2";
    }

    @RequestMapping("allBestEatJjim2")
    public String allBestJjim2(Model model, @RequestParam HashMap map) throws Exception {
        // Your existing code
        List<Map<String, Object>> eatjjim = mainService.eatjjim(map);
        List<Map<String, Object>> cafejjim = mainService.cafejjim(map);


        // Create a list to store average emotion results
        List<Double> eatEmoResults = new ArrayList<>();
        List<Double> cafeEmoResults = new ArrayList<>();

        // Iterate through eatjjim list and retrieve hotplace_no for each entry
        for (Map<String, Object> entry : eatjjim) {
            int hotplace_no = (int) entry.get("hotplace_no");

            // Use hotplace_no to query and calculate average emotion result
            //double avgEmoResult = mainService.emoAnalAvg(hotplace_no);
            //eatEmoResults.add(avgEmoResult);
        }

        // Repeat the same process for cafejjim list
        for (Map<String, Object> entry : cafejjim) {
            int hotplace_no = (int) entry.get("hotplace_no");

            // Use hotplace_no to query and calculate average emotion result
            //double avgEmoResult = mainService.emoAnalAvg(hotplace_no);
            //cafeEmoResults.add(avgEmoResult);
        }

        // Now, you have lists eatEmoResults and cafeEmoResults containing average emotion results
        // You can add these lists to the model for use in your template
        model.addAttribute("eatjjim", eatjjim);
        model.addAttribute("cafejjim", cafejjim);
        return "main/test2";
    }

    @RequestMapping("allBestEatJjim3")
    public String allBestJjim3(Model model) throws Exception {
        List<HashMap<String, Object>> eatjjim = mainService.eatjjim2();
        List<HashMap<String, Object>> cafejjim = mainService.cafejjim2();
        //EmoreviewDTO avg_emo_result = mainService.eatjjim2();
        //System.out.println("eatjjim="+eatjjim);
        System.out.println("cafejjim"+cafejjim);

        //model.addAttribute("eatjjim",eatjjim);
        model.addAttribute("cafejjim",cafejjim);
        model.addAttribute("eatjjim",eatjjim);
        return "main/test2";
    }



}
