package com.shijie.sb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by ShiJie on 2018-11-02 01:09
 */
@RestController
@RequestMapping("/chart")
public class EchartController {

    @GetMapping("/index")
    public ModelAndView hello(){

        return new ModelAndView("index");//跟templates文件夹下的test.html名字一样，返回这个界面

    }

    @GetMapping("/test")
    public ModelAndView test(){

        return new ModelAndView("test");//跟templates文件夹下的test.html名字一样，返回这个界面

    }

    @GetMapping("/demo")
    public ModelAndView demo(){

        return new ModelAndView("demo");//跟templates文件夹下的demo.html名字一样，返回这个界面

    }

}
