package com.inhatc.spring.Service;

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
