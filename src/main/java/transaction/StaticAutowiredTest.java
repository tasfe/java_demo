package transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by zhdxu on 2017/8/9.
 */
@Component
public class StaticAutowiredTest {

    public static OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        StaticAutowiredTest.orderService = orderService;
    }

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("spring-context.xml").start();
        orderService.update1();
    }
}
