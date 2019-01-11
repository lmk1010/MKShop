package com.nexus.manager.shiro;

import org.apache.shiro.config.Ini;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.util.CollectionUtils;

/**
 * @ClassName MyShiroFilter
 * @Description TODO 继承ShiroFilterFactoryBean,复写实现动态的URL权限匹配控制器
 * @Author liumingkang
 * @Date 2019-01-10 22:42
 * @Version 1.0
 **/
public class MyShiroFilter extends ShiroFilterFactoryBean {


    @Override
    public void setFilterChainDefinitions(String definitions) {

        //todo 将/user/login=auth 存入数据库 做动态匹配

        Ini ini = new Ini();
        ini.load(definitions);
        Ini.Section section = ini.getSection("urls");
        if (CollectionUtils.isEmpty(section)) {
            section = ini.getSection("");
        }

        this.setFilterChainDefinitionMap(section);

    }
}
