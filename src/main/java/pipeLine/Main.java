package pipeLine;

/**
 * Created by zhdxu on 2017/8/4.
 */
public class Main {

    public static void main(String[] args){
        MyPipeLine pipeline=new MyPipeLine();
        pipeline.addFirst(new TestHandler2());//添加handler1
        pipeline.addFirst(new TestHandler1());//添加handler2
        for(int i=0;i<1;i++){//提交多个任务
            pipeline.Request("hello"+i);
        }
    }
}
