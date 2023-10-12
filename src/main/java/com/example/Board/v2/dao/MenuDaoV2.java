package com.example.Board.v2.dao;

import com.example.Board.v2.vo.Coffee_menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper // myBatis 사용, 해당 부분이 데이터를 연동해줌
public interface MenuDaoV2 {
    List<Coffee_menu> doList();

    int doInsert(Coffee_menu coffeeMenu);

    int doDelete(int strNo);

    Map<String, Object> doUpdateInfo(String strNo);

    int doUpdate(Coffee_menu coffeeMenu);

    List<Coffee_menu> doSearch(String strStartDate, String strEndDate, String strCoffee, String strKind);

    int doupdatePrice(String strNo, String strPrice);
}
