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

    /**
     *功能描述
     * @Author liumingkang
     * @Description //TODO
     * @Date 2019-01-07
     * @Param []
     * @Return java.lang.String
     */
    @RequestMapping(value = "getdemo.do",method = RequestMethod.GET)
    @ResponseBody
    public String getDemo(){
        return "hello springMVC";
    }


}
