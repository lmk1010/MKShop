package com.nexus.manager.shiro;

import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

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
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //从shiro获取凭证
        String username = (String) authenticationToken.getPrincipal();
        String password = (String) authenticationToken.getCredentials();

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

        if (password.equals(loginUser.getPassword())){
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                    loginUser.getUsername(), //用户名
                    loginUser.getPassword(), //密码
                    getName()  //realm name
            );
        }



        return null;
    }
}
