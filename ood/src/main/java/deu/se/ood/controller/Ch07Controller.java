/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.se.ood.controller;

import java.io.File;
import javax.servlet.ServletContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author CHANG
 */

@Controller
@Slf4j
public class Ch07Controller {
    
    @Autowired
    private ServletContext ctx;
    
    @GetMapping("/ch07/upload")
    public String upload() {
        return "/ch07/upload/index";
    }
    
    @PostMapping("/ch07/upload.do")
    public String uploadDo(
            @RequestParam String username, 
            @RequestParam MultipartFile upFile, 
            Model model) {
        log.debug("upload.do: username = {}, upfile = {}, File.separator = {}",
                username, upFile.getOriginalFilename(), File.separator);
        
        String basePath = ctx.getRealPath("/WEB-INF") + File.separator + "upload";
        log.debug("upload.do: basePath = {}", basePath);
        File baseDir = new File(basePath);
        if (!baseDir.exists()) {
            baseDir.mkdirs();
        }
        if ("".equals(username) || "".equals(upFile.getOriginalFilename())) {
            log.debug("username = \"{}\", upfile = \"{}\"", username, upFile.getOriginalFilename());
            model.addAttribute("exec_message",
                String.format("username(%s)이 없거나 upload 파일(%s) 지정이 되지 않습니다.",
                        username, upFile.getOriginalFilename()));
        } else {
            
        }
        
        
        return "/ch07/upload.do/index";
    }
}
