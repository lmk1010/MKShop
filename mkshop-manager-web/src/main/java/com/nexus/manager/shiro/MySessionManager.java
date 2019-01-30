package com.nexus.manager.shiro;

import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.UUID;

/**
 * @ClassName MySessionManager
 * @Description TODO 重写websessionmanager实现token验证登陆
 * @Description 因为对于app或者小程序 不能使用cookie，使用token进行验证 那么我们重写shiro原本寻找session的方式(不从cookie寻找，我们从请求头中获取token
 * )本质上都是一串string而已，只是更改其sessionid的获取路径，保持sessionid即token与客户端的一致性即可。
 * @Author liumingkang
 * @Date 2019-01-14 10:04
 * @Version 1.0
 * @status 已废弃
 **/
public class MySessionManager extends DefaultWebSessionManager {

    private static final String TOKEN_NAME = "token";

    private static final String HEADER_TOKEN_NAME = "token";

    @Override
    public Serializable getSessionId(SessionKey key) {
        //sessionKey是对象，sessionid是序列化的String字符串，
        //sessionid算是sessionKey的一个属性
        Serializable sessionId = key.getSessionId();
        if (sessionId == null && WebUtils.isWeb(key)) {
            ServletRequest request = WebUtils.getRequest(key);
            ServletResponse response = WebUtils.getResponse(key);
            sessionId = this.getSessionId(request, response);
        }

        return sessionId;
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {

        HttpServletRequest httprequest = (HttpServletRequest) request;

        String Token = httprequest.getHeader(HEADER_TOKEN_NAME);
        //如果客户端带来的token为空 那么随机生成一个token
        if (Token != null) {
            Token = UUID.randomUUID().toString();
        }
        request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, ShiroHttpServletRequest.COOKIE_SESSION_ID_SOURCE);
        request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, Token);
        request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
        request.setAttribute(ShiroHttpServletRequest.SESSION_ID_URL_REWRITING_ENABLED, this.isSessionIdUrlRewritingEnabled());

        return Token;
    }
}
