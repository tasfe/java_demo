package transaction;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhdxu on 2017/8/4.
 */
@Service
public class OrderService {

    public void update1() {
        System.out.println("test ...");
    }

    /**
     * 需要事物，自己开启or与调用方有事物时与调用方保持一致
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public void update2() {

        throw new RuntimeException("update2 runtimeException ...");
    }

    /**
     * 与调用方事物保持一致，调用方无事物，则该方法也无事物
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.SUPPORTS)
    public void update3() {

        throw new RuntimeException("update3 runtimeException ...");
    }

    /**
     * 只能被开启了事物的方法调用，并保持和调用方事物一致，否则报错
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.MANDATORY)
    public void update4() {

        throw new RuntimeException("update4 runtimeException ...");
    }

    /**
     * 会新起一个事物
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void update5() {

        throw new RuntimeException("update5 runtimeException ...");
    }

    /**
     * 不支持事物（会以非事物状态运行）
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    public void update6() {

        throw new RuntimeException("update6 runtimeException ...");
    }

    /**
     * 不能在事物中运行
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NOT_SUPPORTED)
    public void update7() {

        throw new RuntimeException("update7 runtimeException ...");
    }

    /**
     *
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void update8() {

        throw new RuntimeException("update8 runtimeException ...");
    }

}
