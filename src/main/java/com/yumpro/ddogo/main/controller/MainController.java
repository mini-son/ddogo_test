package com.yumpro.ddogo.main.controller;

import com.yumpro.ddogo.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

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
        List eatjjim = mainService.eatjjim(map);
        List cafejjim = mainService.cafejjim(map);
        System.out.println("eatjjim="+eatjjim);
        System.out.println("cafejjim"+cafejjim);
        model.addAttribute("eatjjim",eatjjim);
        model.addAttribute("cafejjim",cafejjim);
        return "main/test2";
    }



}
