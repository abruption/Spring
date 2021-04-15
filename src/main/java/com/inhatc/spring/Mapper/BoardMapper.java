package com.inhatc.spring.Mapper;

import com.inhatc.spring.DTO.BoardDto;

import java.util.HashMap;
import java.util.List;

public interface BoardMapper {
    List<?> selectSubjectList(HashMap<String, Object> map) throws Exception;
    List<BoardDto> selectSubjectList2(String name) throws Exception;
    int selectSubjectListCount(String name) throws Exception;
    int insertSubject(HashMap<String, String> map) throws Exception;
    HashMap selectDetail(String no) throws Exception;
    int modifySubject(HashMap<String, String> map) throws Exception;
    int deleteSubject(String no) throws  Exception;
}
