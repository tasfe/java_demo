import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import transaction.OrderService;

/**
 * Created by zhdxu on 2017/8/9.
 */
@Component
public class Test2 {

    @Autowired
    public OrderService orderService;

    public void test() {
        new ClassPathXmlApplicationContext("spring-context.xml").start();
        orderService.update1();
    }
}
