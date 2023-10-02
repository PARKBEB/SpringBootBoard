package com.example.Board.v1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenuCon {
    @RequestMapping("/v1/menu")
    public String doMenu(Model model) { // Model객체는 컨트롤러 메서드에서 뷰로 데이터를 전달하는 데 사용
        // Data 만들기, List, Map
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("No", "1");
        map.put("name", "카페라떼");
        map.put("kind", "커피");
        map.put("price", "5,000");
        map.put("reg_day", "2020.10.29");
        map.put("mod_day", "2021.10.29");
        list.add(map);

        map.clear();
        map.put("No", "1");
        map.put("name", "아이스아메리카노");
        map.put("kind", "커피");
        map.put("price", "5,000");
        map.put("reg_day", "2020.10.29");
        map.put("mod_day", "2021.10.29");
        list.add(map);

        // Data 송부
        model.addAttribute("list", list);
        model.addAttribute("hello", "Menucon");

        return "/v1/menu/menu";
    }
}
