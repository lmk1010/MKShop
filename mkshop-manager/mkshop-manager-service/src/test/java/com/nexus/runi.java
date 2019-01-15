package com.nexus;


import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-db.xml")
public class runi {

    @Autowired
    private UserService userService;

    @Test
    public void rer(){

        /*
        TbUser tbUser = userService.select_user(1);
        String s = DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes());
        tbUser.setPassword(s);

        userService.updateUser(tbUser);
        */

        /*
        TbUser tbUser = new TbUser();
        tbUser.setUsername("customer");
        tbUser.setPassword("1010");
        tbUser.setStatus(1);
        tbUser.setRoleId(3);

        userService.insert_user(tbUser);
        */

    }


}
