package com.nexus.manager.shiro;

import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Set;

/**
 * @ClassName MyRealm
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-08 15:57
 * @Version 1.0
 **/
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //授权过程
        //获取用户凭证中的username
        String username = principalCollection.getPrimaryPrincipal().toString();
        //创建用户授权凭证
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //取DB查询该用户的角色列表和权限
        //并且进行授权
        authorizationInfo.setRoles(userService.findAllRoles(username));
        authorizationInfo.setStringPermissions(userService.findAllPermissions(username));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //从shiro获取凭证
        String username = (String) authenticationToken.getPrincipal();

        //从DB获取该用户对象
        TbUser loginUser = userService.selectUserByName(username);

        //进行验证
        //没找到账号就抛出账号不对的异常
        if (loginUser==null){
            throw new UnknownAccountException();
        }
        //检查用户状态，
        if (loginUser.getStatus()==0){
            throw new LockedAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    loginUser.getUsername(), //用户名
                    loginUser.getPassword(), //密码
                    getName()  //realm name
            );
        return authenticationInfo;
    }
}
