package pipeLine;

/**
 * Created by zhdxu on 2017/8/4.
 */
public class TestHandler2 implements Handler{

    public void channelRead(HandlerContext ctx, Object msg) {
        //// TODO: 2016/11/22
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result=(String)msg+"-handler2";
        System.out.println(result);
        ctx.write(result);
    }
}
