package com.example.Board.v2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v2")
public class HomeConV2 {

    @GetMapping("/home")
    public String doHome() {
        return "/v2/home/home";
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
        return "/v2/home/home";
    }

    @PostMapping("/home2")
    public String doHome2Post() {
        System.out.println("Post");
        return "/v2/home/home";
    }
}
