package pipeLine;

/**
 * Created by zhdxu on 2017/8/4.
 */
public class TestHandler1 implements Handler{

    public void channelRead(HandlerContext ctx, Object msg) {
        //// TODO: 2016/11/22
        try {
            Thread.sleep(8000);//模拟阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String result=(String)msg+"-handler1";//在字符串后面加特定字符串
        System.out.println(result);
        ctx.write(result);//写入操作，这个操作是必须的，相当于将结果传递给下一个handler
    }
}
