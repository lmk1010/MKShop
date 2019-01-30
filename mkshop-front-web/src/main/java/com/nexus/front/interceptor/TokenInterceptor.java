package com.nexus.front.interceptor;

import com.alibaba.fastjson.JSON;
import com.nexus.common.jedis.JedisOperater;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName TokenInterceptor
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-30 14:43
 * @Version 1.0
 **/
@Log4j
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JedisOperater jedisOperater;


    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        log.info("<--------------prehandle-------------->");
        log.info("<--------从header中获取认证Token------->");
        String token = httpServletRequest.getHeader("Token");
        if (jedisOperater.exists(token)){
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
