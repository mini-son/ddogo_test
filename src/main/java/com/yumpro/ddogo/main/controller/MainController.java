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

  /*  @RequestMapping("allBestEatJjim")
    public String allBestJjim(Model model, @RequestParam HashMap map) throws Exception {
        List<Map<String, Object>> eatjjim = mainService.eatjjim(map);
        List<Map<String, Object>> cafejjim = mainService.cafejjim(map);
        System.out.println("eatjjim="+eatjjim);
        System.out.println("cafejjim"+cafejjim);

        model.addAttribute("eatjjim",eatjjim);
        model.addAttribute("cafejjim",cafejjim);
        return "main/test2";
    }
*/

    @RequestMapping("allBestEatJjim")
    public String allBestJjim3(Model model) throws Exception {
        List<HashMap<String, Object>> eatjjim = mainService.eatjjim();
        List<HashMap<String, Object>> cafejjim = mainService.cafejjim();
        System.out.println("cafejjim"+cafejjim);

        model.addAttribute("cafejjim",cafejjim);
        model.addAttribute("eatjjim",eatjjim);
        return "main/test2";
    }



}
