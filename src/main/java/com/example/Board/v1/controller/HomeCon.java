package com.example.Board.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1")
public class HomeCon {

    @GetMapping("/home")
    public String doHome() {
        return "/v1/home/home";
    }

    @GetMapping("/rest2")
    @ResponseBody // Controller + ResponseBody의 역할이 합쳐져서 RestController의 역할을 함
    public String doRest2() {
        String strHtml = "<html><body>Hi Rest <hr> ^*^ </html></body>";

        return strHtml;
    }

    @GetMapping("/home2")
    public String doHome2Get() {
        System.out.println("Get");
        return "/v1/home/home";
    }

    @PostMapping("/home2")
    public String doHome2Post() {
        System.out.println("Post");
        return "/v1/home/home";
    }
}
