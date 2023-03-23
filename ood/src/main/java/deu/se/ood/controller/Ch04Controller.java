/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.controller;

import deu.se.ood.beans.ch04.SumSpringBean;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author CHANG
 */
@Controller
@Slf4j
public class Ch04Controller {
    @Autowired
    private ServletContext ctx;
    @Autowired
    private SumSpringBean sumBean;

    @GetMapping("/ch04/beans")
    public String ch04Beans(Model m) {
        log.debug("Real path of \"/\" = {}", ctx.getRealPath("/"));
        m.addAttribute("ctx_path", ctx.getRealPath("/"));
        
        return "ch04/beans/index";    // index.jsp
    }
    
    @PostMapping("/ch04/beans/show_sum1")
    public String ch04BeansShowSum(HttpServletRequest request) {
        log.debug("show_sum: n = {}", request.getParameter("n"));
        
        return "ch04/beans/show_sum1";
    }
    
    @PostMapping("/ch04/beans/show_sum2")
    public String ch04BeansShowSum2(@RequestParam String n, Model model) {
        log.debug("show_sum2: n = {}", n);
        sumBean.setN(Integer.parseInt(n));
        sumBean.calculate();
        
        model.addAttribute("result", sumBean.getResult());
        
        return "ch04/beans/show_sum2";
    }
    
}
