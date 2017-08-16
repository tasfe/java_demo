package transaction;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by zhdxu on 2017/8/4.
 */
public interface OrderMapper{

    @Update("update mem_vip_order set status = #{status} where id = #{orderId}")
    void updateOrder(@Param("status") int status, @Param("orderId") int orderId);
}
