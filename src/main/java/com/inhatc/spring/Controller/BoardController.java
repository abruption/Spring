package com.inhatc.spring.Controller;

import com.inhatc.spring.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    /* BoardService boardService = new boardServer()로 객체 생성 시에는 숫자가 각각 올라가지만,
       @Autowired 어노테이션을 사용할 시에는 객체를 공유한다. → Singleton 방식으로 객체가 관리됨  */
    @Autowired
    BoardService boardService;

    @RequestMapping("board")
    public ModelAndView board(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", boardService.hello());
        mv.addObject("count", boardService.getCount());
        mv.setViewName("board");        // JSP 파일 이름
        return mv;
    }

    @RequestMapping("board2")
    public ModelAndView board2(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", boardService.hello());
        mv.setViewName("board");        // JSP 파일 이름
        System.out.println(boardService.getCount());
        return mv;
    }

    @RequestMapping("board3")
    public ModelAndView board3(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", boardService.hello());
        mv.addObject("num", 10);
        mv.setViewName("board");        // JSP 파일 이름
        return mv;
    }
}
