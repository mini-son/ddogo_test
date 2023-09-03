package com.yumpro.ddogo.main.controller;

import com.yumpro.ddogo.main.service.MainService;
import com.yumpro.ddogo.main.service.OptionService;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

    //오늘 전국 베스트 찜
    @RequestMapping("allBestJjim")
    public String allBestJjim(Model model) throws Exception {
        //맛집
        List<HashMap<String, Object>> eatjjim = mainService.eatjjim();
        //카페
        List<HashMap<String, Object>> cafejjim = mainService.cafejjim();
        System.out.println("eatjjim"+eatjjim);
        System.out.println("cafejjim"+cafejjim);

        model.addAttribute("cafejjim",cafejjim);
        model.addAttribute("eatjjim",eatjjim);
        return "main/main";
    }

    @RequestMapping("ex")
    public String ex(){
        return "main/select.html";
    }

    @RequestMapping(value = "/{option1}", produces = "application/json; charset=UTF-8", method= RequestMethod.GET)
    @ResponseBody
    public void get_option2(HttpServletResponse res, @PathVariable String option1) throws IOException {

        //List<Option> options = OptionService.findOption2(option1);
        List<String> optionList = new ArrayList();

      /*  for (int i = 0; i < options.size(); i++) {
            optionList.add(options.get(i).getOption2());
        }
*/
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < optionList.size(); i++) {
            jsonArray.put(optionList.get(i));
        }

        PrintWriter pw = res.getWriter();
        pw.print(jsonArray.toString());
        pw.flush();
        pw.close();
    }
}
