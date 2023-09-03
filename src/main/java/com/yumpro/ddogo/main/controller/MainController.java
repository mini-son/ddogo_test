package com.yumpro.ddogo.main.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yumpro.ddogo.main.dto.SidogugunDTO;
import com.yumpro.ddogo.main.service.MainService;
import jakarta.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
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
/*
    @RequestMapping(value = "/{option1}", produces = "application/json; charset=UTF-8", method= RequestMethod.GET)
    @ResponseBody
    public void get_option2(HttpServletResponse res, @PathVariable String option1) throws IOException {

        //List<Option> options = OptionService.findOption2(option1);
        List<String> optionList = new ArrayList();*/

      /*  for (int i = 0; i < options.size(); i++) {
            optionList.add(options.get(i).getOption2());
        }
*/
  /*      JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < optionList.size(); i++) {
            jsonArray.put(optionList.get(i));
        }

        PrintWriter pw = res.getWriter();
        pw.print(jsonArray.toString());
        pw.flush();
        pw.close();
    }*/

    @GetMapping(value = "test3")
    public String select_ajax(HttpServletResponse response) throws Exception {

        Map<String,List<String>> sigunguMap = mainService.getsidogungu();
        JSONObject obj = new JSONObject();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        for(String sidoKey: sigunguMap.keySet() ) { //map의 key의 개수만큼=<=(중복되지않는)sido의 개수만큼
            List<String> sigunguList = sigunguMap.get(sidoKey);
            JSONArray jsonArr = new JSONArray(); //배열준비
            System.out.printf("시도별%s 시군구개수%d \r\n",sidoKey,sigunguList.size());
            for( String gugun :sigunguList) { //sido별  sigungu의 개수만큼
                jsonArr.put(gugun);
            }
            obj.put(sidoKey,jsonArr);
        }

        String jsonStr = obj.toString();
        System.out.println("jsonStr ="+jsonStr); //콘솔출력.확인용
        out.print(jsonStr); //client로 보내기
        return "main/select12";
    }

    @RequestMapping("test2")
    public String test() throws Exception {
        return "main/select12";
    }



}
