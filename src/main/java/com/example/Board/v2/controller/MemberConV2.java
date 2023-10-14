package com.example.Board.v2.controller;

import com.example.Board.v2.service.MenuSvcV2;
import com.example.Board.v2.vo.Member;
import com.example.Board.v2.vo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("v2")
public class MemberConV2 {

    @Autowired
    MenuSvcV2 menuSvcV2;
    @RequestMapping("/member")
    public String doMember(Model model) {
        List<Member> list = menuSvcV2.doMember();

        model.addAttribute("list", list);

        return "/v2/member/member";
    }
    @PostMapping("/member_search")
    public String doMemberSearch(@RequestParam("start_date") String strStartDate,
                                @RequestParam("end_date") String strEndDate,
                                @RequestParam(value = "name", defaultValue = "ALL") String strName, Model model) {
        List<Member> list = menuSvcV2.doMemberSearch(strStartDate, strEndDate, strName);
        model.addAttribute("list", list);

        return "/v2/member/member";
    }
}