package com.nexus;

import static org.junit.Assert.assertTrue;

import com.nexus.manager.pojo.TbUser;
import com.nexus.manager.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.InetAddress;

/**
 * Unit test for simple App.
 */
public class AppTest 
{


    @Test
    public void te() throws Exception
    {

        String address = InetAddress.getLocalHost().getHostAddress().toString();
        System.err.println(address);
    }
}
