import com.nexus.common.utils.JWTUtils;
import com.nexus.front.service.CartService;
import com.nexus.manager.mapper.TbCartMapper;
import com.nexus.manager.pojo.TbCart;
import com.nimbusds.jose.JOSEException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestDB
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-22 21:29
 * @Version 1.0
 **/
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring-config.xml")
public class TestDB {

    @Test
    public void wewe() throws JOSEException {

        Map<String,Object> map = new HashMap<>();

        map.put("token", "hahaha");

        String s = JWTUtils.creatToken(map);

        System.err.println(s);
    }
}
