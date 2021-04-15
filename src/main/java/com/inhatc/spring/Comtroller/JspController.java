package com.inhatc.spring.Comtroller;

import com.inhatc.spring.DTO.BoardDto;
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

import java.util.HashMap;
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


    @RequestMapping("/testdb.do")
    public ModelAndView board(@RequestParam(name = "test",required = false,defaultValue = "연습페이지")String id,
                              @RequestParam(name = "page",required = false,defaultValue = "1")Integer page) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("board2");
        mv.addObject("id", id);
//        model.addAttribute("id",id);
        try {
            List<?> l = jspService.selectSubjectList(id, page);
            int count = jspService.selectSubjectListCount(id);
            mv.addObject("subjectList", l);
            mv.addObject("count", count);
//            model.addAttribute("subjectList", l);
//            model.addAttribute("count",count);
            System.out.println(l.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping("/testdb2")
    public String board2(Model model,
                         @RequestParam(name = "test",required = false,defaultValue = "연습페이지")String id) {
        model.addAttribute("id",id);
        try {
            List<BoardDto> l = jspService.selectSubjectList2("심리학");
            model.addAttribute("subjectList", l);
            System.out.println(l.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "board3";
    }

    @RequestMapping("testdb")
    public String board3(Model model,
                         @RequestParam(name = "test",required = false,defaultValue = "연습페이지")String id) {
        model.addAttribute("id",id);
        try {
            List<?> l = jspService.selectSubjectList(id, 1);
            int count = jspService.selectSubjectListCount(id);
            model.addAttribute("subjectList",l);
            model.addAttribute("count",count);
            System.out.println(l.toString());
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "board4";
    }

    @RequestMapping("/boardDetail.do")
    public ModelAndView boardDetail(String no) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("boardDetail");
        mv.addObject("selectDetail",jspService.selectDetail(no));
        mv.addObject("title", "상세");
        return mv;
    }

    @RequestMapping("/regSubject.do")
    public ModelAndView rebSubject() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", "등록");
        mv.setViewName("boardDetail");
        return mv;
    }

    @RequestMapping("/insertSubject.do")
    public ModelAndView insertSubject(String subject, String grade, String useYn, String description, String regUser) throws Exception {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("subject", subject);
        hashMap.put("grade", grade);
        hashMap.put("useYn", useYn);
        hashMap.put("description", description);
        hashMap.put("regUser", regUser);
        jspService.insertSubject(hashMap);
        return boardDetail("");
    }

    @RequestMapping("/modifySubject.do")
    public ModelAndView modifySubject(String id, String subject, String grade, String useYn, String description, String regUser) throws Exception {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("id", id);
        hashMap.put("subject", subject);
        hashMap.put("grade", grade);
        hashMap.put("useYn", useYn);
        hashMap.put("description", description);
        hashMap.put("regUser", regUser);
        jspService.modifySubject(hashMap);
        return boardDetail(id);
    }

    @RequestMapping("/deleteSubject.do")
    public ModelAndView deleteSubject(String no) throws Exception {
        jspService.deleteSubject(no);
        return board("", 1);
    }
}
