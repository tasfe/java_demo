package transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhdxu on 2017/8/4.
 */
@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public void update1() {
        System.out.println("test ...");
    }

    /**
     * 需要事物，自己开启or与调用方有事物时与调用方保持一致
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void update2() {

        update6();

        orderMapper.updateOrder(0, 105794);
        System.out.println("update2 runtimeException ... status 0");

       // update3();


        throw new RuntimeException("update2 runtimeException ... status 0");


    }

    /**
     * 与调用方事物保持一致，调用方无事物，则该方法也无事物
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    public void update3() {
        orderMapper.updateOrder(1, 105794);
        System.out.println("update3 runtimeException ... status 1");
        //throw new RuntimeException("update3 runtimeException ... status 1");
    }

    /**
     * 只能被开启了事物的方法调用，并保持和调用方事物一致，否则报错
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void update4() {
        orderMapper.updateOrder(2, 105794);
        System.out.println("update4 runtimeException ... status 2");
        //throw new RuntimeException("update4 runtimeException ... status 2");
    }

    /**
     * 会新起一个事物
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void update5() {
        orderMapper.updateOrder(3, 105794);
        System.out.println("update5 runtimeException ... status 3");
        //throw new RuntimeException("update5 runtimeException ... status 3");
    }

    /**
     * 不支持事物（会以非事物状态运行）
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    public void update6() {
        orderMapper.updateOrder(4, 105794);
        System.out.println("update6 runtimeException ... status 4");
        //throw new RuntimeException("update6 runtimeException ... status 4");
    }

    /**
     * 不能在事物中运行
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    public void update7() {
        orderMapper.updateOrder(5, 105794);
        System.out.println("update7 runtimeException ... status 5");
        throw new RuntimeException("update7 runtimeException ... status 5");
    }

    /**
     *
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void update8() {
        orderMapper.updateOrder(0, 105794);
        System.out.println("update8 runtimeException ... status 0");
        throw new RuntimeException("update8 runtimeException ... status 0");
    }

}
