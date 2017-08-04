package pipeLine;

/**
 * Created by zhdxu on 2017/8/4.
 */
public interface Handler {

    void channelRead(HandlerContext ctx, Object msg);
}
