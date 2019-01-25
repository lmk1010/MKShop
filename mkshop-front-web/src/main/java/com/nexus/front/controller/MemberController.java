package com.nexus.front.controller;

import com.nexus.common.cache.TokenCache;
import com.nexus.common.model.Constant;
import com.nexus.common.model.ResponseCode;
import com.nexus.common.model.ServerResponse;
import com.nexus.common.utils.RandomUtil;
import com.nexus.front.service.MemberService;
import com.nexus.manager.pojo.TbMember;
import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.DemoService;
import com.nexus.manager.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.zookeeper.server.SessionTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.tools.jstat.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

/**
 * @ClassName UseController
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-14 15:41
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/member/")
@Api(value = "前台用户接口",description = "前台用户修改用户信息等")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping(value = "hello",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ApiOperation(httpMethod = "GET",value = "测试demo",
            produces = "application/json;charset=UTF-8",notes = "测试接口demo 同时测试dubbo服务是否正常")
    public String hello(){
        return "hjellp "+memberService.hello("lmk");
    }







}
