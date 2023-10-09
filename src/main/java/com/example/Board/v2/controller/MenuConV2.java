package com.example.Board.v2.controller;

import com.example.Board.v2.service.MenuSvcV2;
import com.example.Board.v2.vo.Coffee_menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("v2")
public class MenuConV2 {

    @Autowired // 아래 서비스를 bean에서 가져와 사용함
    MenuSvcV2 menuSvc;

    @RequestMapping("/menu")
    public String doMenu(Model model) { // Model객체는 컨트롤러 메서드에서 뷰로 데이터를 전달하는 데 사용
        // Data 만들기, List, Map
        List<Coffee_menu> list = menuSvc.doList();


        // Data 송부
        model.addAttribute("list", list);
        model.addAttribute("hello", "Menucon");

        return "/v2/menu/menu";
    }

    @GetMapping("/menu_ins")
    public String doInsert() {
        return "/v2/menu/menu_ins";
    }

    @PostMapping("/menu_ins")
    public String doInsertPost(@RequestParam("coffee") String strCoffee,
                               @RequestParam("kind") String strKind,
                               @RequestParam("price") String strPrice
    ) {
        int i = menuSvc.doInsert(strCoffee, strKind, strPrice);
        System.out.println("Test10 : " + i);

        return "redirect:/v2/menu";
    }

    @GetMapping("/menu_del")
    public String doDelete(@RequestParam("no") int strNo) {

        menuSvc.doDelete(strNo);

        return "redirect:/v2/menu";
    }

    @GetMapping("/menu_up")
    public String doUpdateInfo(@RequestParam("no") String strNo, Model model) {

        Map<String, Object> map = menuSvc.doUpdateInfo(strNo);

        model.addAttribute("map", map);
        // model.addAttribute("strNo", strNo);
        System.out.println("strNoTest2: " + strNo);


        return "/v2/menu/menu_up";
    }

    @PostMapping("/menu_up")
    public String doUpdate(@RequestParam("coffee") String strCoffee,
                           @RequestParam("kind") String strKind,
                           @RequestParam("price") String strPrice,
                           @RequestParam("no") String strNo
    ) {
        int i = menuSvc.doUpdate(strCoffee, strKind, strPrice, strNo);

        return "redirect:/v2/menu";
    }

    @PostMapping("/menu_search")
    public String doSearch(@RequestParam("start_date") String strStartDate,
                           @RequestParam("end_date") String strEndDate,
                           @RequestParam(value = "coffee", defaultValue = "ALL") String strCoffee,
                           @RequestParam(value = "kind", defaultValue = "ALL") String strKind, Model model) {

        System.out.println("TEST01 : " + strStartDate + " " + strEndDate + " " + strCoffee + " " + strKind);

        List<Coffee_menu> list = menuSvc.doSearch(strStartDate, strEndDate, strCoffee, strKind);
        model.addAttribute("list", list);

        System.out.println("END01 : " + model);

        return "/v2/menu/menu";
    }

    @PostMapping("/updatePrice")
    public String doupdatePrice(@RequestParam("chkCoffeeNo") List<String> chkList,
                                @RequestParam("hidden_price") String strPrice) {

        if (chkList != null) {
            for (String strNo : chkList) {
                int i = menuSvc.doupdatePrice(strNo, strPrice);
            }
        }

        return "redirect:/v2/menu";
    }
}
