package com.yumpro.ddogo.main.controller;

import com.yumpro.ddogo.main.service.MainService;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    private MainService mainService;

    public void mapno(){
        int mapno = mainService.mapno;
    }

}
