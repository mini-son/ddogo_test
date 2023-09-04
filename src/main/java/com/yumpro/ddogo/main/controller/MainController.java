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


    //-----------------test-----------------
    @GetMapping(value = "select2")
    public String select_ajax_test(HttpServletResponse response,Model model) throws Exception {

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


        //String getSido = sidogugunDTO.getSido();
        //String getGugun = sidogugunDTO.getGugun();
        //System.out.println("getSido="+getSido);
        //System.out.println("getGugun="+getGugun);
        //SidogugunDTO sidogugunDTO = mainService.monthBest();


        return "main/select23";
    }


    @GetMapping(value = "sigunguMap2", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, List<String>> select_ajax2_test(
            @RequestParam(name = "sido") String sido,
            @RequestParam(name = "gugun") String gugun,
            HttpServletResponse response, Model model) throws Exception {
        Map<String, List<String>> sigunguMap = mainService.getsidogungu();
        model.addAttribute("sigunguMap",sigunguMap);
        System.out.println("sigunguMap"+sigunguMap);

        List<HashMap<String, Object>> monthBestList = mainService.monthBest(sido,gugun);
        System.out.println("monthBestList"+monthBestList);
        return sigunguMap;
    }




    //-----------------test2 버튼 만들기-----------------
    @GetMapping(value = "select3")
    public String select_ajax_test2(HttpServletResponse response,
                                    Model model) throws Exception {

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
        System.out.println("sigunguMap_test3"+sigunguMap);


        //String getSido = sidogugunDTO.getSido();
        //String getGugun = sidogugunDTO.getGugun();
        //System.out.println("getSido="+getSido);
        //System.out.println("getGugun="+getGugun);
        //SidogugunDTO sidogugunDTO = mainService.monthBest();


        return "main/select31";
    }


 /*   @GetMapping(value = "sigunguMap4", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, List<String>> select_ajax2_test2(
            @RequestParam(name = "sido") String sido,
            @RequestParam(name = "gugun") String gugun,
            HttpServletResponse response, Model model) throws Exception {
        Map<String, List<String>> sigunguMap = mainService.getsidogungu();
        model.addAttribute("sigunguMap",sigunguMap);
        System.out.println("sigunguMap"+sigunguMap);

        List<HashMap<String, Object>> monthBestList = mainService.monthBest(sido,gugun);
        model.addAttribute("monthBestList", monthBestList);
        System.out.println("monthBestList"+monthBestList);
        return sigunguMap;
    }*/

    // 초기 데이터를 가져오는 엔드포인트
    @GetMapping(value = "initialData", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, List<String>> getInitialData() throws Exception {
        Map<String, List<String>> sigunguMap = mainService.getsidogungu();
        return sigunguMap;
    }

    /*@GetMapping("select3?sido={sido}&gugun={gugun}")
    public String detail(@RequestParam(name = "sido") String sido,
                         @RequestParam(name = "gugun") String gugun){
        List<HashMap<String, Object>> monthBestList = mainService.monthBest(sido,gugun);
        return "main/imsi";
    }*/


}
