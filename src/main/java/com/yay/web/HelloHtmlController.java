package com.yay.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述: Thymeleaf Controller
 * @author yangyang26
 * @version 1.0
 * @since 2016/12/27 15:24
 */
@Controller
public class HelloHtmlController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "https://www.baidu.com");
        return "index";
    }

}
