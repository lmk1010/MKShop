import com.nexus.common.model.ServerResponse;
import com.nexus.manager.dto.search.EsInfo;
import com.nexus.search.mapper.ItemMapper;
import com.nexus.search.service.updateIndexService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName TestDb
 * @Description TODO
 * @Author liumingkang
 * @Date 2019-02-18 15:36
 * @Version 1.0
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring-db.xml")
public class TestDb {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private updateIndexService updateIndexService;



    @Test
    public void testDB(){

        ServerResponse esInfo = updateIndexService.updateIndexAllItem();

        System.err.println(esInfo.getMsg());

    }


}
