package com.example.Board.v1.controller;

import com.example.Board.v1.service.MenuSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("v1")
public class MenuCon {

    @Autowired // 아래 서비스를 bean에서 가져와 사용함
    MenuSvc menuSvc;

    @RequestMapping("/menu")
    public String doMenu(Model model) { // Model객체는 컨트롤러 메서드에서 뷰로 데이터를 전달하는 데 사용
        // Data 만들기, List, Map
        List<Map<String, Object>> list = menuSvc.doList();


        // Data 송부
        model.addAttribute("list", list);
        model.addAttribute("hello", "Menucon");

        return "/v1/menu/menu";
    }

    @GetMapping("/menu_ins")
    public String doInsert() {
        return "/v1/menu/menu_ins";
    }

    @PostMapping("/menu_ins")
    public String doInsertPost(@RequestParam("coffee") String strCoffee,
                               @RequestParam("kind") String strKind,
                               @RequestParam("price") String strPrice
    ) {
        int i = menuSvc.doInsert(strCoffee, strKind, strPrice);

        return "redirect:/v1/menu";
    }

    @GetMapping("/menu_del")
    public String doDelete(@RequestParam("no") int strNo) {

        menuSvc.doDelete(strNo);

        return "redirect:/v1/menu";
    }

    @GetMapping("/menu_up")
    public String doUpdateInfo(@RequestParam("no") String strNo, Model model) {

        Map<String, Object> map = menuSvc.doUpdateInfo(strNo);

        model.addAttribute("map", map);
        // model.addAttribute("strNo", strNo);
        System.out.println("strNoTest2: " + strNo);


        return "/v1/menu/menu_up";
    }

    @PostMapping("/menu_up")
    public String doUpdate(@RequestParam("coffee") String strCoffee,
                           @RequestParam("kind") String strKind,
                           @RequestParam("price") String strPrice,
                           @RequestParam("no") String strNo
    ) {
        int i = menuSvc.doUpdate(strCoffee, strKind, strPrice, strNo);

        return "redirect:/v1/menu";
    }

    @GetMapping("/menu_search")
    public String doSearch(@RequestParam("start_date") String strStartDate,
                           @RequestParam("end_date") String strEndDate,
                           @RequestParam("coffee") String strCoffee,
                           @RequestParam("kind") String strKind, Model model) {

        List<Map<String, Object>> list = menuSvc.doSearch(strStartDate, strEndDate, strCoffee, strKind);

        return "list";
    }
}
