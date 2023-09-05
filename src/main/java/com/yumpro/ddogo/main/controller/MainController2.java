package com.yumpro.ddogo.main.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@Controller
public class MainController2 {
    @Autowired
    private MainService mainService;


    //-----------------test2 버튼 만들기-----------------
    @GetMapping(value = "select3")
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
    }




  /*  @PostMapping(value = "select3")
    public ResponseEntity<String> sidogugunPost(HttpServletResponse response,
                                                @RequestParam(name = "sido") String selectedSido,
                                                @RequestParam(name = "gugun") String selectedGugun,
                                                Model model) throws Exception {
        System.out.println("post진입");
        System.out.println("selectedSido="+selectedSido);
        System.out.println("selectedGugun="+selectedGugun);
        response.setContentType("text/html; charset=UTF-8");
        //response.setContentType("application/json; charset=UTF-8");
        PrintWriter out = response.getWriter();
        // mainService.monthBest(selectedSido, selectedGugun)을 실행하여 원하는 데이터를 가져옴
        List<HashMap<String, Object>> monthBestList=mainService.monthBest(selectedSido,selectedGugun);
        System.out.println("monthBestList="+monthBestList);
       *//* JSONObject obj2 = new JSONObject();
        JSONArray monthBestListArr = new JSONArray(); //배열준비
        for( int i=0; i<monthBestList.size(); i++ ){
            JSONArray jsonArr2 = new JSONArray(); //배열준비
            obj2.put("sido",monthBestList.get(1).get(selectedSido));
            obj2.put("gugun",monthBestList.get(2).get(selectedGugun));
            monthBestListArr.put(obj2);
        }

        String jsonStr2 = obj2.toString();
        System.out.println("jsonStr2 ="+jsonStr2); //콘솔출력.확인용
        out.print(jsonStr2); //client로 보내기*//*

        model.addAttribute("monthBestList", monthBestList);
        // JSON 응답 객체 생성
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("monthBestList", monthBestList);

        return null;
        //return new ResponseEntity<>(monthBestList, HttpStatus.OK);
    }*/













  /*  @PostMapping(value = "select3")
    public ResponseEntity<String> sidogugunPost(HttpServletResponse response,
            @RequestParam(name = "sido") String selectedSido,
            @RequestParam(name = "gugun") String selectedGugun) throws Exception {

        // mainService.monthBest(selectedSido, selectedGugun)을 실행하여 원하는 데이터를 가져옴
        List<HashMap<String, Object>> monthBestList = mainService.monthBest(selectedSido, selectedGugun);

        // monthBestList를 JSON 형식으로 변환
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("objectMapper="+objectMapper);
        String jsonStr_month = objectMapper.writeValueAsString(monthBestList);
        System.out.println("jsonStr_month" + jsonStr_month);

        // JSON 응답 반환
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(jsonStr_month, responseHeaders, HttpStatus.OK);
    }*/


 /*   @PostMapping(value = "select3")
    public String sidogugunPost(HttpServletResponse response,
                            @RequestParam(name = "sido") String selectedSido,
                            @RequestParam(name = "gugun") String selectedGugun,
                                    Model model) throws Exception {

        Map<String,List<String>> sigunguMap = mainService.getsidogungu();
        JSONObject obj = new JSONObject();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        for(String sidoKey: sigunguMap.keySet() ) { //map의 key의 개수만큼=<=(중복되지않는)sido의 개수만큼
            List<String> sigunguList = sigunguMap.get(sidoKey);
            JSONArray jsonArr = new JSONArray(); //배열준비
            System.out.printf("시도별%s 시군구개수%d \r\n",sidoKey,sigunguList.size());
            for( String gugun1 :sigunguList) { //sido별  sigungu의 개수만큼
                jsonArr.put(gugun1);
            }
            obj.put(sidoKey,jsonArr);
        }

        model.addAttribute("sigunguMap",sigunguMap);
        System.out.println("sigunguMap_test3"+sigunguMap);

        String jsonStr = obj.toString();
        System.out.println("jsonStr ="+jsonStr); //콘솔출력.확인용
        out.print(jsonStr); //client로 보내기
        model.addAttribute(jsonStr);

        List<HashMap<String, Object>> monthBestList=mainService.monthBest(selectedSido,selectedGugun);
        JSONObject obj2 = new JSONObject();
        JSONArray monthBestListArr = new JSONArray(); //배열준비
        for( int i=0; i<monthBestList.size(); i++ ){
            JSONArray jsonArr2 = new JSONArray(); //배열준비
            obj2.put("sido",monthBestList.get(1).get(selectedSido));
            obj2.put("gugun",monthBestList.get(2).get(selectedGugun));
            monthBestListArr.put(obj2);
        }

        String jsonStr2 = obj2.toString();
        System.out.println("jsonStr2 ="+jsonStr2); //콘솔출력.확인용
        out.print(jsonStr2); //client로 보내기

        return null;
    }*/


  /*  @PostMapping(value = "select3")
    public String sidogugunPost(HttpServletResponse response,
                            @RequestParam(name = "sido") String sido,
                            @RequestParam(name = "gugun") String gugun,
                                    Model model) throws Exception {

        Map<String,List<String>> sigunguMap = mainService.getsidogungu();
        JSONObject obj = new JSONObject();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        for(String sidoKey: sigunguMap.keySet() ) { //map의 key의 개수만큼=<=(중복되지않는)sido의 개수만큼
            List<String> sigunguList = sigunguMap.get(sidoKey);
            JSONArray jsonArr = new JSONArray(); //배열준비
            System.out.printf("시도별%s 시군구개수%d \r\n",sidoKey,sigunguList.size());
            for( String gugun1 :sigunguList) { //sido별  sigungu의 개수만큼
                jsonArr.put(gugun1);
            }
            obj.put(sidoKey,jsonArr);
        }

        model.addAttribute("sigunguMap",sigunguMap);
        System.out.println("sigunguMap_test3"+sigunguMap);

        String jsonStr = obj.toString();
        System.out.println("jsonStr ="+jsonStr); //콘솔출력.확인용
        out.print(jsonStr); //client로 보내기
        model.addAttribute(jsonStr);

        List<HashMap<String, Object>> monthBestList=mainService.monthBest(sido,gugun);
        JSONObject obj2 = new JSONObject();
        obj2.put("sido", sido); // sido 추가
        obj2.put("gugun", gugun); // gugun 추가

        String jsonStr2 = obj.toString();
        System.out.println("jsonStr2_test =" + jsonStr2); // 콘솔 출력. 확인용


      *//*  List<HashMap<String, Object>> monthBestList=mainService.monthBest(sido,gugun);
        JSONObject obj2 = new JSONObject();
        JSONArray monthBestListArr = new JSONArray(); //배열준비
        for( int i=0; i<monthBestList.size(); i++ ){
            JSONArray jsonArr2 = new JSONArray(); //배열준비
            obj2.put("sido",monthBestList.get(1).get(sido));
            obj2.put("gugun",monthBestList.get(2).get(gugun));
            monthBestListArr.put(obj2);
        }

        String jsonStr2 = obj2.toString();
        System.out.println("jsonStr2 ="+jsonStr2); //콘솔출력.확인용
        out.print(jsonStr2); //client로 보내기*//*

        return null;
    }*/


}

