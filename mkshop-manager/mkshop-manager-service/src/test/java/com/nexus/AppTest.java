package com.nexus;

import static org.junit.Assert.assertTrue;

import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class AppTest 
{

    @Autowired
    private UserService userService;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void te()
    {

        TbUser t1 = userService.select_user(1);
        System.out.println(t1.toString());
    }
}
