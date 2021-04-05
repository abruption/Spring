package com.inhatc.spring.Service;

import java.util.List;

import com.inhatc.spring.Mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class JspService {
    @Autowired
    BoardMapper boardMapper;

    public List<?> selectSubjectList(String name) throws Exception{
        return boardMapper.selectSubjectList(name);
    }
}
