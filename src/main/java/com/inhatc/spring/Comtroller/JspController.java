package com.inhatc.spring.Comtroller;

import com.inhatc.spring.Service.BoardService;
import com.inhatc.spring.Service.JspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.inhatc.spring.Service.JspService;
import com.inhatc.spring.Service.BoardService;

import java.util.List;

@Controller
public class JspController {
    @Autowired
    JspService jspService;


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

    @RequestMapping("/testdb")
    public String board(Model model,
                        @RequestParam(name = "test",required = false,defaultValue = "연습페이지")String id) {
        model.addAttribute("id",id);
        try {
            List<?> l = jspService.selectSubjectList("");
            model.addAttribute("subjectList", l);
            System.out.println(l.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "board2";
    }

}
