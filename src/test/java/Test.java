import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import transaction.OrderService;

/**
 * Created by zhdxu on 2017/8/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:spring-context.xml"})
public class Test {

    static OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        Test.orderService = orderService;
    }

    @org.junit.Test
    public void test() {

        orderService.update1();
    }
}
