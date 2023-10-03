package com.example.Board.v1.controller;

import com.example.Board.v1.service.MenuSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuCon {

    @Autowired // 아래 서비스를 bean에서 가져와 사용함
    MenuSvc menuSvc;
    @RequestMapping("/v1/menu")
    public String doMenu(Model model) { // Model객체는 컨트롤러 메서드에서 뷰로 데이터를 전달하는 데 사용
        // Data 만들기, List, Map
        List<Map<String, Object>> list = menuSvc.doList();


        // Data 송부
        model.addAttribute("list", list);
        model.addAttribute("hello", "Menucon");

        return "/v1/menu/menu";
    }
}
