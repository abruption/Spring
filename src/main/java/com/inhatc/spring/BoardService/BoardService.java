package com.inhatc.spring.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    int count;

    public String hello(){
        return "hello";
    }

    public int getCount(){
        return count++;
    }
}
