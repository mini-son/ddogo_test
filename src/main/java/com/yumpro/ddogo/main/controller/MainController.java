package com.yumpro.ddogo.main.controller;

import com.yumpro.ddogo.main.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class MainController {
    @Autowired
    private MainService mainService;

    @RequestMapping("test")
    public int mapno() throws Exception {

        int mapno = mainService.mapno();

        System.out.println("mapno="+mapno);
        return mapno;
    }

}
