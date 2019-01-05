package com.nexus.manager.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user/")
@Slf4j
public class UserController {


    @RequestMapping(value = "getdemo.do",method = RequestMethod.GET)
    @ResponseBody
    public String getDemo(){
        return "hello springMVC";
    }


}
