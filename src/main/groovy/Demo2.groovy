/**
 * Created by zhdxu on 2017/8/16.
 */
class Demo2 {

    Demo demo;

    Demo getDemo() {
        return demo
    }

    void setDemo(Object demo) {
        if(demo instanceof String)
            this.demo = new Demo(demo)
        else
            this.demo = demo
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2()
        demo2.demo = "222"
        println(demo2.demo.name)
    }
}
