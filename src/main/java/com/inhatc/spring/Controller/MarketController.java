package com.inhatc.spring.Controller;

import com.inhatc.spring.DTO.MemberDto;
import com.inhatc.spring.Service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MarketController {
    @Autowired
    MarketService marketService;

    @RequestMapping("/welcome.do")
    public ModelAndView welcome(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        mv.addObject("sessionId", request.getSession().getAttribute("sessionId"));
        return mv;
    }

    @RequestMapping("/member/addMember.do")
    public ModelAndView addMember() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/addMember");
        return mv;
    }

    @RequestMapping("/member/processAddMember.do")
    public ModelAndView processAddMember(MemberDto dto) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/addMember");
        marketService.processAddMember(dto);
        System.out.println(dto);
        return mv;
    }

    @RequestMapping("/member/loginMember.do")
    public ModelAndView loginMember() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("member/loginMember");
        return mv;
    }

    @RequestMapping("/member/processLoginMember.do")
    public ModelAndView processLoginMember(HttpServletRequest request, MemberDto dto) throws Exception {
        dto = marketService.processLoginMember(dto);
        System.out.println(dto);
        HttpSession session = request.getSession();
        session.setAttribute("sessionId", dto.getName());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        return mv;
    }
}
