package com.example.Board.v2.controller;

import com.example.Board.v2.service.MenuSvcV2;
import com.example.Board.v2.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("v2")
public class OrderConV2 {

    @Autowired
    MenuSvcV2 menuSvcV2;
    @RequestMapping("/order")
    public String doOrder(Model model) {
        List<Order> list = menuSvcV2.doOrder();

        model.addAttribute("list", list);


        return "/v2/order/order";
    }

    @PostMapping ("/order/search")
    public String doOrderSearch(@RequestParam("start_date") String strStartDate,
                                @RequestParam("end_date") String strEndDate,
                                @RequestParam(value = "coffee", defaultValue = "ALL") String strCoffee,
                                @RequestParam(value = "name", defaultValue = "ALL") String strName, Model model) {
        List<Order> list = menuSvcV2.doOrderSearch(strStartDate, strEndDate, strCoffee, strName);
        model.addAttribute("list", list);

        return "/v2/order/order";
    }
}
