package transaction;

import org.springframework.data.jpa.repository.Query;

/**
 * Created by zhdxu on 2017/8/4.
 */
public interface OrderMapper {

    @Query(value = "update mem_vip_order set status = ?1 where id = ?2", nativeQuery = true)
    void updateOrder(int status, int orderId);
}
