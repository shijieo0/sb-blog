package com.shijie.sb.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 博客控制器
 * Created by ShiJie on 2018-11-22 23:38
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {

    private final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

    @GetMapping
    public String listBlogs(@RequestParam(value="order", required = false, defaultValue = "new") String order,
                            @RequestParam(value="keyword", required = false, defaultValue = "") Long keyword) {
        LOGGER.info("order="+order+"; keyword="+keyword);
        return "redirect:/index?order="+order+"&keyword="+keyword;
    }

}
