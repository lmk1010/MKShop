import com.nexus.common.jedis.JedisOperater;
import com.nexus.common.utils.JedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @ClassName redisTest
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-01-15 11:12
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class redisTest {

    @Autowired
    private JedisOperater JedisOperater;

    @Test
    public void test2(){

        JedisOperater.set("shangwu22", "333");

    }

}
