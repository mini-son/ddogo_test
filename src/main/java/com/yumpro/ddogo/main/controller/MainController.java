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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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


    @GetMapping(value = "select")
    public String select_ajax(HttpServletResponse response,Model model) throws Exception {

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
        //out.print(jsonStr); //client로 보내기
        model.addAttribute(jsonStr);
        model.addAttribute("sigunguMap",sigunguMap);
        System.out.println("sigunguMap_test2"+sigunguMap);
        return "main/select";
    }



    @GetMapping(value = "sigunguMap", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, List<String>> select_ajax2(HttpServletResponse response, Model model) throws Exception {
        Map<String, List<String>> sigunguMap = mainService.getsidogungu();
        model.addAttribute("sigunguMap",sigunguMap);
        System.out.println("sigunguMap"+sigunguMap);
        return sigunguMap;
    }


  



    //---------------한번에 main2.html-------------------
    //오늘 전국 베스트 찜
    @RequestMapping("main")
    public String main(HttpServletResponse response,Model model) throws Exception {
        //일별 베스트
        //맛집
        List<HashMap<String, Object>> eatjjim = mainService.eatjjim();
        //카페
        List<HashMap<String, Object>> cafejjim = mainService.cafejjim();
        System.out.println("eatjjim"+eatjjim);
        System.out.println("cafejjim"+cafejjim);

        model.addAttribute("cafejjim",cafejjim);
        model.addAttribute("eatjjim",eatjjim);

        //월별베스트
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
        //out.print(jsonStr); //client로 보내기
        model.addAttribute(jsonStr);
        model.addAttribute("sigunguMap",sigunguMap);
        System.out.println("sigunguMap_test2"+sigunguMap);

        return "main/main3";

    }

    @GetMapping(value = "sigunguMap3", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, List<String>> select_ajax3(HttpServletResponse response, Model model) throws Exception {
        Map<String, List<String>> sigunguMap = mainService.getsidogungu();
        model.addAttribute("sigunguMap",sigunguMap);
        System.out.println("sigunguMap"+sigunguMap);
        return sigunguMap;
    }



    //-----------------test2 버튼 만들기-----------------
  /*  @GetMapping(value = "select3")
    public String select_ajax_test2(HttpServletResponse response,
                                    Model model) throws Exception {

        Map<String, List<String>> sigunguMap = mainService.getsidogungu();
        JSONObject obj = new JSONObject();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        for (String sidoKey : sigunguMap.keySet()) { //map의 key의 개수만큼=<=(중복되지않는)sido의 개수만큼
            List<String> sigunguList = sigunguMap.get(sidoKey);
            JSONArray jsonArr = new JSONArray(); //배열준비
            System.out.printf("시도별%s 시군구개수%d \r\n", sidoKey, sigunguList.size());
            for (String gugun : sigunguList) { //sido별  sigungu의 개수만큼
                jsonArr.put(gugun);
            }
            obj.put(sidoKey, jsonArr);
        }

        String jsonStr = obj.toString();
        System.out.println("jsonStr =" + jsonStr); //콘솔출력.확인용
        //out.print(jsonStr); //client로 보내기
        model.addAttribute(jsonStr);
        model.addAttribute("sigunguMap", sigunguMap);
        System.out.println("sigunguMap_test3" + sigunguMap);


        return "main/select38";
    }


    // 초기 데이터를 가져오는 엔드포인트
    @GetMapping(value = "initialData", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, List<String>> getInitialData() throws Exception {
        Map<String, List<String>> sigunguMap = mainService.getsidogungu();
        return sigunguMap;
    }


    //-----------------------------------
    @PostMapping(value = "select3", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> sidogugunPost(
            @RequestParam(name = "sido") String selectedSido,
            @RequestParam(name = "gugun") String selectedGugun,
            Model model) throws Exception {
        System.out.println("post진입");
        System.out.println("selectedSido=" + selectedSido);
        System.out.println("selectedGugun=" + selectedGugun);

        // mainService.monthBest(selectedSido, selectedGugun)을 실행하여 원하는 데이터를 가져옴
        List<HashMap<String, Object>> monthBestList = mainService.monthBest(selectedSido, selectedGugun);
        System.out.println("monthBestList=" + monthBestList);

        // JSON 응답 객체 생성
        Map<String, Object> responseMap = new HashMap<>();
        System.out.println("responseMap"+responseMap);
        responseMap.put("monthBestList", monthBestList);
        model.addAttribute("monthBestList", monthBestList);

        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }*/



}
