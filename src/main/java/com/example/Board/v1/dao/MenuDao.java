package com.example.Board.v1.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper // myBatis 사용, 해당 부분이 데이터를 연동해줌
public interface MenuDao {
    List<Map<String, Object>> doList();
}
