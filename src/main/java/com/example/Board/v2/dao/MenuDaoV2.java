package com.example.Board.v2.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper // myBatis 사용, 해당 부분이 데이터를 연동해줌
public interface MenuDaoV2 {
    List<Map<String, Object>> doList();

    int doInsert(String strCoffee, String strKind, String strPrice);

    int doDelete(int strNo);

    Map<String, Object> doUpdateInfo(String strNo);

    int doUpdate(String strCoffee, String strKind, String strPrice, String strNo);

    List<Map<String, Object>> doSearch(String strStartDate, String strEndDate, String strCoffee, String strKind);

    int doupdatePrice(String strNo, String strPrice);
}
