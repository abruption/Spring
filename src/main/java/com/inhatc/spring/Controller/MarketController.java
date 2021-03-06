package com.inhatc.spring.Controller;

import com.inhatc.spring.DTO.MemberDto;
import com.inhatc.spring.DTO.ProductDto;
import com.inhatc.spring.Service.MarketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.reflect.annotation.ExceptionProxy;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MarketController {
    @Autowired
    MarketService marketService;

    private static final Logger Log = LoggerFactory.getLogger(MarketService.class);

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
        mv.setViewName("/member/addMember");
        return mv;
    }

    @RequestMapping("/member/processAddMember.do")
    public ModelAndView processAddMember(MemberDto dto) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/member/addMember");
        marketService.processAddMember(dto);
        System.out.println(dto);
        return mv;
    }

    @RequestMapping("/member/loginMember.do")
    public ModelAndView loginMember() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/member/loginMember");
        return mv;
    }

    @RequestMapping("/member/processLoginMember.do")
    public ModelAndView processLoginMember(HttpServletRequest request, MemberDto dto) throws Exception {
        dto = marketService.processLoginMember(dto);
        System.out.println(dto);
        HttpSession session = request.getSession();
        if(dto != null) {
            session.setAttribute("sessionId", dto.getName());
            session.setAttribute("userId", dto.getId());
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("welcome");
        return mv;
    }

    @RequestMapping("/member/logoutMember.do")
    public ModelAndView logoutMember(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return welcome(request);
    }

    @RequestMapping("/member/updateMember.do")
    public ModelAndView updateMember(HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/member/updateMember");

        HttpSession session = request.getSession();

        MemberDto dto = new MemberDto();
        dto.setId(session.getAttribute("userId").toString());
        System.out.println(dto.getId());
        dto = marketService.processMemberInfo(dto);
        System.out.println(dto);
        mv.addObject("member", dto);
        return mv;
    }

    @RequestMapping("/member/processUpdateMember.do")
    public ModelAndView processUpdateMember(HttpServletRequest request, MemberDto dto) throws Exception{
        System.out.println(dto);
        marketService.processUpdateMember(dto);
        return updateMember(request);
    }

    @RequestMapping("/member/deleteMember.do")
    public ModelAndView deleteMember(HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/member/deleteMember");

        HttpSession session = request.getSession();
        session.setAttribute("sessionId", session.getAttribute("userId"));
        return mv;
    }

    @RequestMapping("/member/resultMember.do")
    public ModelAndView resultMember(HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/member/resultMember");
        return mv;
    }

    // addProduct.do
    @RequestMapping("/addProduct.do")
    public ModelAndView addProduct(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/addProduct");
        HttpSession session = request.getSession();
        mv.addObject("sessionId", session.getAttribute("sessionId"));
        return mv;
    }

    @RequestMapping("/product/processAddProduct.do")
    public ModelAndView processAddProduct(ProductDto dto, HttpServletRequest request, MultipartFile productImage) throws Exception{
        Log.warn(dto.toString());
        Log.info(productImage.getName());
        marketService.saveImage(dto, productImage);
        marketService.processAddProduct(dto);

        return addProduct(request);
    }

    @RequestMapping("/products.do")
    public ModelAndView products(HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("products");
        HttpSession session = request.getSession();
        List<ProductDto> list = marketService.listProducts(null);
        Log.info(list.toString());
        mv.addObject("sessionId", session.getAttribute("sessionId"));
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("/editProduct.do")
    public ModelAndView editProduct(HttpServletRequest request) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editProduct");
        List<ProductDto> list = marketService.listProducts(null);
        Log.info(list.toString());
        HttpSession session = request.getSession();
        mv.addObject("sessionId", session.getAttribute("sessionId"));
        mv.addObject("list", list);
        return mv;
    }

    @RequestMapping("/updateProduct.do")
    public ModelAndView updateProduct(HttpServletRequest request, ProductDto dto) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("updateProduct");
        Log.info(dto.toString());
        dto = marketService.getProduct(dto);
        Log.info(dto.toString());
        mv.addObject("dto", dto);
        HttpSession session = request.getSession();
        mv.addObject("sessionId", session.getAttribute("sessionId"));
        return mv;
    }

    @RequestMapping("/processUpdateProduct.do")
    public ModelAndView processUpdateProduct(ProductDto dto, HttpServletRequest request, MultipartFile productImage) throws Exception{
        Log.warn(dto.toString());
        Log.info(productImage.getName());

        marketService.saveImage(dto, productImage);
        marketService.processUpdateProduct(dto);
        return updateProduct(request, dto);
    }

    @RequestMapping("/deleteProduct.do")
    public ModelAndView deleteProduct(HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/deleteProduct");
        return mv;
    }

    @RequestMapping("/detailProduct.do")
    public ModelAndView detailProduct(HttpServletRequest request, ProductDto dto) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/detailProduct");
        dto = marketService.getProduct(dto);
        mv.addObject("dto", dto);
        HttpSession session = request.getSession();
        mv.addObject("sessionId", session.getAttribute("sessionId"));
        return mv;
    }
}
