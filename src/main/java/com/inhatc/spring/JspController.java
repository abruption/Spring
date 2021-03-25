package com.inhatc.spring;

import com.inhatc.spring.BoardService.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JspController {
    @RequestMapping("/")
    public String index(){
        return "hello";
    }

    @RequestMapping("/hihi")
    public String index2(){
        return "hello";
    }

    @RequestMapping("/data")
    public String data(Model model, String param){
        model.addAttribute("id", param);
        return "data";
    }

    @RequestMapping("/welcome")
    public String webcome(){
        return "welcome";
    }

    @Autowired
    BoardService boardService;
}
