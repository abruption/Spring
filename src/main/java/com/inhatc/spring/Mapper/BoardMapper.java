package com.inhatc.spring.Mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface BoardMapper {
    List<?> selectSubjectList(String name) throws Exception;
}
