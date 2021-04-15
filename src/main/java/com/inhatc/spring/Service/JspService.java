package com.inhatc.spring.Service;

import java.util.HashMap;
import java.util.List;

import com.inhatc.spring.DTO.BoardDto;
import com.inhatc.spring.Mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JspService {
    @Autowired
    BoardMapper boardMapper;

    public List<?> selectSubjectList(String name, Integer page) throws Exception {
        HashMap<String, Object> map = new HashMap<>();
        map.put("keyword", name);
        page = (page-1) * 3;
        map.put("page", page);
        return boardMapper.selectSubjectList(map);
    }

    public List<BoardDto> selectSubjectList2(String name) throws Exception {
        return boardMapper.selectSubjectList2(name);
    }

    public int selectSubjectListCount(String name) throws Exception {
        return boardMapper.selectSubjectListCount(name);
    }

    public int insertSubject(HashMap<String, String> map) throws Exception {
        return boardMapper.insertSubject(map);
    }

    public HashMap selectDetail(String no) throws Exception {
        return boardMapper.selectDetail(no);
    }

    public int modifySubject(HashMap<String, String> map) throws Exception {
        return boardMapper.modifySubject(map);
    }

    public int deleteSubject(String no) throws Exception {
        return boardMapper.deleteSubject(no);
    }

}