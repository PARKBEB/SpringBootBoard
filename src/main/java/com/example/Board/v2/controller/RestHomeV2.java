package com.example.Board.v2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // View의 역할도 함
public class RestHomeV2 {

    @GetMapping("v2/rest")
    public String doRest() {
        String strHtml = "<html><body>Hi Rest <hr> ^*^ </html></body>";

        return strHtml;
    }
}
