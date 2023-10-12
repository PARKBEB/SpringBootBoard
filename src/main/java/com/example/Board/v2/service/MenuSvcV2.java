package com.example.Board.v2.service;

import com.example.Board.v2.dao.MenuDaoV2;
import com.example.Board.v2.vo.Coffee_menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service // IoC 컨테이너에 등록, 객체를 한 번만 생성한 후 재사용하고 싶음 > Bean에 등록된 MenuSvc 사용
// @Log4j2
public class MenuSvcV2 {
    @Autowired
    MenuDaoV2 menuDao;

    public List<Coffee_menu> doList() {
        List<Coffee_menu> list = menuDao.doList();

        return list;
    }
    public MenuSvcV2() {
        System.out.println("1234"); // 호출될 때 객체가 생성되는 것이 아닌 스프링 부트가 실행될 떄,객체 생성됨
    }
    public List<Map<String, Object>> doListOld() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();
        map.put("No", "1");
        map.put("name", "카페라떼");
        map.put("kind", "커피");
        map.put("price", "3,000");
        map.put("reg_day", "2020.10.29");
        map.put("mod_day", "2021.10.29");
        list.add(map);

        Map<String, Object> map2 = new HashMap<>();
        map2.clear();
        map2.put("No", "2");
        map2.put("name", "아이스아메리카노");
        map2.put("kind", "커피");
        map2.put("price", "1,500");
        map2.put("reg_day", "2020.10.29");
        map2.put("mod_day", "2021.10.29");
        list.add(map2);

        Map<String, Object> map3 = new HashMap<>();
        map3.clear();
        map3.put("No", "3");
        map3.put("name", "모카라떼");
        map3.put("kind", "커피");
        map3.put("price", "3,500");
        map3.put("reg_day", "2020.10.29");
        map3.put("mod_day", "2021.10.29");
        list.add(map3);

        // log.info(list);
        return list;
    }

    public int doInsert(Coffee_menu coffeeMenu) {
        int i = menuDao.doInsert(coffeeMenu);
        return i;

    }

    public int doDelete(int strNo) {
         int i = menuDao.doDelete(strNo);
         return i;
    }

    public Map<String, Object> doUpdateInfo(String strNo) {
        Map<String, Object> map = menuDao.doUpdateInfo(strNo);
        return map;
    }

    public int doUpdate(Coffee_menu coffeeMenu) {
        int i = menuDao.doUpdate(coffeeMenu);

        return i;
    }

    public List<Coffee_menu> doSearch(String strStartDate, String strEndDate, String strCoffee, String strKind) {
        System.out.println("TEST02 : " + strStartDate + " " + strEndDate + " " + strCoffee + " " + strKind);

        List<Coffee_menu> list = menuDao.doSearch(strStartDate, strEndDate, strCoffee, strKind);

        System.out.println("END02 :" + list);

        return list;
    }

    public int doupdatePrice(String strNo, String strPrice) {
        int i = menuDao.doupdatePrice(strNo, strPrice);

        return i;
    }
}

