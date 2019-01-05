package com.nexus;


import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class runi {


    @Autowired
    private UserService userService;

    @Test
    public void rer(){

        TbUser tbUser = userService.select_user(1);
        System.err.println(tbUser.toString());
    }


}
